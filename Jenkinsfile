pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/SmitaShetty1411/HybridFramework.git'
            }
        }
        stage('Build') {
            steps {
              
                sh 'echo "Building the project..."'
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Running tests..."'
            }
        }
        stage('Deploy') {
            steps {
              
                sh 'echo "Deploying the application..."'
            }
        }
    }
}
