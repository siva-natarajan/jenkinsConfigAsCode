pipeline {
    agent any
    stages {
        stage('child stage 1') {
            steps {
                script {
                    sh('echo "Hello world"')
                }
                build(
                    job: 'grandChildJob',
                    parameters: [
                        string(name: 'REPOSITORY', value: env.REPOSITORY),
                        string(name: 'SERVICE', value: env.SERVICE),
                        string(name: 'ENVIRONMENT', value: 'frontend-staging')
                    ],
                    propagate: false,
                )
            }
        }
    }
}
