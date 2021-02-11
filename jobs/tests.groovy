import common.ChangedGroovyFiles

job('tests') {
    scm {
        git {
            remote {
                url('https://github.com/siva-natarajan/jenkinsConfigAsCode.git')
            }
            branch('*/main')
        }
    }
    steps {
        shell('''
        echo HELLO WORLD
        ''')
        dsl {
            external('jobs/*.groovy')
            removeAction('DELETE')
            removeViewAction('DELETE')
        }
        script {
            changedFiles = ChangedGroovyFiles.changedFilesList()
            println changedFiles
            echo changedFiles
            if (changedFiles.size() > 0) {
                systemGroovyCommand(readFileFromWorkspace('helpers/copyJob.groovy')) {
                    binding('jobName', 'new')
                    binding('duplicateJobName', 'newDuplicacy')
                }
            }
        }
    }
}
