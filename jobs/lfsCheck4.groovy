pipelineJob('lfsProdJobWithHugeFile') {
    description('Production deployment')

    logRotator {
        daysToKeep(30)
        numToKeep(60)
    }

    definition {
        cpsScm {
            lightweight(true)
            scm {
                git {
                    remote {
                        url('https://github.com/siva-natarajan/gitLFSTest.git')
                    }
                    extensions {
                        gitLFSPull()
                    }
                    branch('*/main')
                    scriptPath('production.Jenkinsfile')
                }
            }
        }
    }
}
