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
        allure(['allure-results-combined']) {
        // Bracket body is needed!
        }
        archiveArtifacts {
            pattern('**/data.txt')
            allowEmpty(true)
        }
    }
}
