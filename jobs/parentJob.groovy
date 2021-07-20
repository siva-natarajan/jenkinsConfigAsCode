// import jobs.common.APIKey

pipelineJob('parentJob') {
    definition {
        cpsScm {
            lightweight(true)
            scm {
                git {
                    remote {
                        url('https://github.com/siva-natarajan/jenkinsConfigAsCode.git')
                    }
                    branch('*/main')
                }
            }
            scriptPath('jenkinsFiles/child.Jenkinsfile')
        }
    }
}
