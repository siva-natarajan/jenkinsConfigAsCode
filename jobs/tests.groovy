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
        systemGroovyScriptFile('helpers/copyJob.groovy') {
        }
    }
}
