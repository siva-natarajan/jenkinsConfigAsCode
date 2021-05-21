pipelineJob('next-app-production') {
    description('Next app Production deployment')

    triggers {
        githubPush()
    }

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
                        github('siva-natarajan/gitLFSTest', 'ssh')
                        credentials(Credentials.GitHubWebhook())
                    }
                }
                scriptPath('deploy.Jenkinsfile')
            }
        }
    }
}
