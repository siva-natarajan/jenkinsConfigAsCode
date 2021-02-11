pipeline {
    agent any
    stages {
        stage('createjobs') {
            steps {
                script {
                    jobDsl targets: 'jobs/*.groovy', removedJobAction: 'DELETE', removedViewAction: 'DELETE'
                }
            }
        }
        stage('cleanup') {
            steps {
                deleteDir()
            }
        }
    }
}
