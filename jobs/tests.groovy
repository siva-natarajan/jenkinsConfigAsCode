job('tests') {
    scm {
        git {
            remote {
                url('https://github.com/siva-natarajan/jenkinsConfigAsCode.git')
            }
            branch('*/main')
        }
    }

    def String changedFiles = 'new.groovy, test.groovy'
    steps {
        shell('''
        echo HELLO WORLD
        ''')
        dsl {
            external('jobs/*.groovy')
            removeAction('DELETE')
            removeViewAction('DELETE')
        }

        systemGroovyCommand(readFileFromWorkspace('helpers/copyJob.groovy')) {
            binding('jobNames', changedFiles)
        }
    }
}
