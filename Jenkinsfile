pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/kappsegla/TestBase.git'

                // Run Maven on a Unix agent.
                sh "./mvn clean package"
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

//pipeline {
//    agent {
//        docker {
//            image 'maven:3.6.3-jdk-11-slim'
//            args '-v ~/.m2:/root/.m2'
//        }
//    }
//    options {
//        skipStagesAfterUnstable()
//    }
//    stages {
//        stage('Build') {
//            steps {
//                sh 'mvn -B -DskipTests clean package'
//            }
//        }
//        stage('Test') {
//            steps {
//                sh 'mvn test'
//            }
//            post {
//                always {
//                    junit 'target/surefire-reports/*.xml'
//                }
//            }
//        }
//        stage('Deploy') {
//            steps {
//                sh './jenkins/deliver.sh'
//            }
//        }
//    }
//}