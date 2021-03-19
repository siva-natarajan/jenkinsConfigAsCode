job('fileArtifact') {
    scm {
        git {
            remote {
                url('https://github.com/siva-natarajan/sampleJsonFileGenerator.git')
            }
            branch('*/main')
        }
    }
    steps {
        shell('''
        echo STARTED EXECUTION
        ''')
        shell('sh src/execute.sh')
        shell('''
        echo DONE EXECUTION
        ''')
        def command = String.format(
            'curl -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d \'{"resultDescription": "%s", "channel": "@sivakumar ", "buildNumber": "%s"}\' https://731e8c31-f578-4b67-b5cb-e2f17dee6e50.trayapp.io',
            '23 passed, 24 failed',
            '123'
        )
        shell(command)
    }

    publishers {
        archiveArtifacts {
            pattern('**/newFile.json')
            pattern('**/newFile.txt')
            allowEmpty(true)
        }
    }

    def command = String.format('curl -s -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d \'{"testStage": "%s", "link": "%s", "ts": "%s", "channel": "#backend-notifications", "requestor": "%s"}\' https://f3247171-9315-4217-93fe-212f8b037559.trayapp.io', testStage, testResultsLink, slackThreadId, env.DEPLOY_REQUESTOR)
    sh(command)
}
