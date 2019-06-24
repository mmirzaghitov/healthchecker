pipeline {
    agent any

    stages {
        stage('clone') {
          steps {
            git credentialsId: 'ca1b23b5-af2d-42e0-a6be-89df324518ee', url: 'git@github.com:mmirzaghitov/healthchecker.git'
          }
        }

        stage('log') {
            steps {
                 sh 'mvn clean package -DskipTests=true'
            }
        }
    }
}
