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
            parallel {
                    script {
                        def externalScriptone = load('stage1.groovy')
                        externalScriptone.stageOne()
                    }
            }
        }
    }

    options {
        timeout(time: 45, unit: 'MINUTES')
        disableConcurrentBuilds()
    }
}
