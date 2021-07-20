// import jobs.common.APIKey

pipelineJob('grandChildJob') {
    concurrentBuild()
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
            scriptPath('jenkinsFiles/grandChild.Jenkinsfile')
        }
    }
}
