job('tests') {
    scm {
        git {
            remote {
                url('https://github.com/siva-natarajan/jenkinsConfigAsCode.git')
            }
            branch('*/main')
        }
    }

    stages {
        stage {
            steps {
                shell('''
            echo HELLO WORLD
            ''')
                dsl {
                    external('jobs/*.groovy')
                    removeAction('DELETE')
                    removeViewAction('DELETE')
                }
            }
        }
        stage {
            script {
                changedFiles = ['new.groov', 'tests.groovy']
                if (changedFiles.size() > 0) {
                    systemGroovyCommand(readFileFromWorkspace('helpers/copyJob.groovy')) {
                        binding('jobName', 'new')
                        binding('duplicateJobName', 'newDuplicacy')
                    }
                }
            }
        }
    }

}
