pipelineJob('lfsProdJob') {
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
                    branch('refs/heads/main')
                    remote {
                        git {
                            url('https://github.com/siva-natarajan/gitLFSTest.git')
                        }
                    }
                    extensions {
                        gitLFSPull()
                    }
                }
                scriptPath('production.Jenkinsfile')
            }
        }
    }
}
