String getBucketNamePrefixed(String bucketName) {
    return 'hello_' + bucketName
}

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

        stage('parallality') {
            steps {
                    def externalScriptone = load('jenkinsFiles/stage1.groovy')
                    externalScriptone.stageOne()
            }
        }
    }

    options {
        timeout(time: 45, unit: 'MINUTES')
        disableConcurrentBuilds()
    }
}
