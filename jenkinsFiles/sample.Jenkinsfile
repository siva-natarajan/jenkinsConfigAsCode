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
                stage('stageOne') {
                    def externalScriptone = load('stage1.groovy')
                    externalScriptone.stageOne()
                }
                stage('stageTwo') {
                    def externalScriptTwo = load('stage2.groovy')
                    externalScriptTwo.stageTwo()
                }
            }
        }
    }

    options {
        timeout(time: 45, unit: 'MINUTES')
        disableConcurrentBuilds()
    }
}
