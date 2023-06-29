pipeline {
    agent any
    
    stages {
        stage('Build and Package - api-transferencia-curso-ms') {
            steps {
                dir('api-transferencia-curso-ms') {
                    bat 'mvn clean package -DskipTests=true'
                }
            }
        }
        
        stage('Build and Package - ejercicio01') {
            steps {
                dir('ejercicio01') {
                    bat 'mvn clean package -DskipTests=true'
                }
            }
        }
        
        stage('Build and Push Docker Images') {
            steps {
                dir('api-transferencia-curso-ms') {
                    bat 'docker build -t rpiombi/transferencias-service:latest ./api-transferencia-curso-ms/'
                    bat 'docker push rpiombi/transferencias-service:latest'
                }
                
                dir('ejercicio01') {
                    bat 'docker build -t rpiombi/clientes-service:latest ./ejercicio01/'
                    bat 'docker push rpiombi/clientes-service:latest'
                }
            }
        }
    }
}