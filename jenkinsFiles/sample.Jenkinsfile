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
                stage('stage1') {
                    steps {
                        sh('''
                        echo HELLO WORLD stage1
                        ''')
                    }
                }

                stage('stage 2') {
                    steps {
                        sh('''
                        echo HELLO WORLD stage2
                        ''')
                    }
                }
            }
        }
    }

    options {
        timeout(time: 45, unit: 'MINUTES')
        disableConcurrentBuilds()
    }
}
