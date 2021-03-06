// import jobs.common.APIKey

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
        // shell("echo /$APIKey.ApiKeyGetter()")
        shell('echo /$(git diff-tree --no-commit-id --name-only -r -m HEAD jobs/*.groovy)')
        environmentVariables {
            env('CHANGED_FILES', 'new, old')
        }
        dsl {
            external('jobs/*.groovy')
            removeAction('DELETE')
            removeViewAction('DELETE')
        }

        systemGroovyCommand(readFileFromWorkspace('helpers/copyJob.groovy')) {
        }
    }
}
