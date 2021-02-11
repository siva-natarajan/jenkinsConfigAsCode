job('tests') {
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
