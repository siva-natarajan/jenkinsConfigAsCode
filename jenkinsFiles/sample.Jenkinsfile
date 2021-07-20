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
                // script {
                //     def externalScriptone = load('jenkinsFiles/stage1.groovy')
                //     externalScriptone.stageOne()
                // }
                parallel(
                    'first': {
                        def externalScriptone = load('jenkinsFiles/stage1.groovy')
                        externalScriptone.stageOne()
                    }
                )
        }
    }

    options {
        timeout(time: 45, unit: 'MINUTES')
        disableConcurrentBuilds()
    }
}
