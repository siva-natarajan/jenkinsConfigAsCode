job('fileArtifact') {
    steps {
        git {
            remote {
                url('https://github.com/siva-natarajan/sampleJsonFileGenerator.git')
            }
            branch('*/main')
        }
        shell('sh ./src/execute.sh')
    }
    publishers {
        archiveArtifacts {
            pattern('./src/newFile.json')
            allowEmpty(true)
        }
    }
}
