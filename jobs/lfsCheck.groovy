pipelineJob('lfsProdJob') {
    description('Production deployment')

    triggers {
        githubPush()
    }

    logRotator {
        daysToKeep(30)
        numToKeep(60)
    }

    wrappers {
        preScmSteps {
            steps {
                shell('git lfs install')
            }
            failOnError()
        }
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
