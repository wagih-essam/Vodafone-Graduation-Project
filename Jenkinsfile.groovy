pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('Cleanup') {
            steps {
                deleteDir()  // Deletes all files in the workspace before cloning
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main',
                        credentialsId: 'git-credentials',
                        url: 'https://github.com/wagih-essam/Vodafone-Graduation-Project.git'
            }
        }

        stage('Testing') {
            steps {
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        stage('Allure Report') {
            steps {
                script {
                    def allureResultsPath = 'allure-results'  // Path to allure-results directory
                    def allureReportPath = 'allure-report'    // Output path for allure-report
                    def zipFile = 'report.zip' // Name of the zip file

                    // Debug: Print directory structure before generating report
                    bat "echo --- Before Generating Allure Report ---"
                    bat "dir /s /b"

                    // Check if allure-results exists before generating the report
                    if (fileExists(allureResultsPath)) {
                        bat "allure generate ${allureResultsPath} --clean -o ${allureReportPath}"

                        // Debug: Check if Allure report was actually created
                        bat "echo --- After Generating Allure Report ---"
                        bat "dir ${allureReportPath} /s /b"

                        // Ensure the Allure report directory exists before zipping
                        if (fileExists(allureReportPath)) {
                            bat "powershell Compress-Archive -Path ${allureReportPath}/* -DestinationPath ${zipFile}"
                            echo "Allure report zipped successfully: ${zipFile}"
                        } else {
                            echo "Allure report directory does not exist, skipping zip step."
                        }
                    } else {
                        echo "Skipping Allure Report generation as ${allureResultsPath} is missing."
                    }
                }
            }
        }
    }

    post {
        always {
            // Debug: Check if report.zip exists before archiving
            bat "echo --- Checking if report.zip Exists ---"
            bat "dir /s /b report.zip || echo report.zip NOT FOUND"

            // Archive the zipped Allure report
            archiveArtifacts artifacts: 'report.zip', fingerprint: true

            // Publish Allure report as HTML
            publishHTML(target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'allure-report',
                    reportFiles: 'index.html',
                    reportName: 'Allure Report'
            ])
        }
    }
}
