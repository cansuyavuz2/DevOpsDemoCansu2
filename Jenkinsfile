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
                        sh './gradlew test'
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
