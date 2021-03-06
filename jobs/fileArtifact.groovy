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
    }

    publishers {
        archiveArtifacts {
            pattern('**/dummyFile.txt')
            allowEmpty(true)
        }
        postBuildTask {
            task('checkout', 'curl -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d \'{"channel": "@sivakumar", "buildNumber": "\'${BUILD_NUMBER}\'"}\' https://731e8c31-f578-4b67-b5cb-e2f17dee6e50.trayapp.io')
        }
    }
}
