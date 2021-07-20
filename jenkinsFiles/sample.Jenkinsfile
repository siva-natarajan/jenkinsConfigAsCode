pipeline {
    agent any

    stages {
        stage('Create Slack Notification') {
            steps {
                script {
                    deploymentSlackNotificationId = 'hello'
                }
            }
        }
    }

    options {
        timeout(time: 45, unit: 'MINUTES')
        disableConcurrentBuilds()
    }
}
