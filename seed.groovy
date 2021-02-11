pipeline {
    agent any
    stages {
        stage('createjobs') {
            steps {
                shell ('set CLASSPATH=jobs/common')
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
