pipeline {
    agent any
    stages {
        stage('createjobs') {
            steps {
                additionalClasspath('jobs/common')
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
