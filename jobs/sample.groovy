
pipelineJob('Sample Job') {
    description('General pipeline')

    definition {
        cpsScm {
            lightweight(true)
            scm {
                git {
                    branch('refs/heads/main')

                    remote {
                        url('https://github.com/siva-natarajan/jenkinsConfigAsCode.git')
                    }
                }
                scriptPath('jenkinsFile/sample.Jenkinsfile')
            }
        }
    }
}
