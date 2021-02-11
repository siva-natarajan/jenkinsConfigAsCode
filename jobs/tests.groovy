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
        def String changedFiles = shell('git diff-tree --no-commit-id --name-only -r -m HEAD jobs/*.groovy')
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
