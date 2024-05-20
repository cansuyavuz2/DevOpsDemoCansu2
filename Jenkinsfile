pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                sh 'echo checkout'
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/cansuyavuz2/DevOpsDemoCansu2.git']])
                }
        }
        stage('Test Backend') {
            steps {
                dir('backend') {
                    script {
                        if (fileExists('build.gradle')) {
                            echo 'Running Gradle test for backend'
                            sh 'gradle test'
                        } else {
                            error 'No build.gradle file found in backend directory'
                        }
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo deploy'
            }
        }
}
}
