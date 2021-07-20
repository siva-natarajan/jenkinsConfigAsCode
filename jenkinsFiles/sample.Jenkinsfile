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
                "stage1": {
                    def externalScript = load("stage1.groovy")
                    externalScript.stageOne()
                },
                "stage2": {
                    def externalScript = load("stage2.groovy")
                    externalScript.stageTwo()
                }
            }
        }
    }

    options {
        timeout(time: 45, unit: 'MINUTES')
        disableConcurrentBuilds()
    }
}
