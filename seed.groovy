pipeline {
    agent any
    stages {
        stage('createjobs') {
            steps {
                script {
                    sh('echo "A test failed. Slack has been notified of it, thus we can safely mark this stage as failed."')
                    sh('echo $CLASSPATH')
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
