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
        shell('sh ./src/execute.sh')
        shell('''
        echo DONE EXECUTION
        ''')
    }
    publishers {
        archiveArtifacts {
            pattern('./src/newFile.json')
            allowEmpty(true)
        }
    }
}
