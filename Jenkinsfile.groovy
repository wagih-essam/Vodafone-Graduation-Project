pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
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
        stage('Build') {
            steps {

                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
