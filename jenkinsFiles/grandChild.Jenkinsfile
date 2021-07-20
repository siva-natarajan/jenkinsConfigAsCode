pipeline {
    agent any
    stages {
        stage('grand child stage 1') {
            steps {
                script {
                    sh('echo "Hello world"')
                }
            }
        }

        stage('grand child stage 2') {
            steps {
                script {
                    sh('echo "Hello world"')
                }
            }
        }
        parallel {
            stage('grand child stage 3') {
                steps {
                    script {
                        sh('echo "Hello world"')
                    }
                }
            }

            stage('grand child stage 4') {
                steps {
                    script {
                        sh('echo "Hello world"')
                    }
                }
            }
        }
    }
}
