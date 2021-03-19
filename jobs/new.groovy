job('new') {
    steps {
        shell('''
        echo HELLO WORLD
        ''')
        shell('''
        echo 'This is a test' > data.txt
        ''')
    }
    publishers {
        archiveArtifacts {
            pattern('**/data.txt')
            allowEmpty(true)
        }
    }
}
