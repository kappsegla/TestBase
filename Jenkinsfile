pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-11-slim'
            args '-v ~/.m2:/root/.m2'
        }
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deploy') {
            agent {none}
            steps {
                sh './jenkins/deliver.sh'
            }
        }
    }
}