job('new') {
    steps {
        shell('''
        echo HELLO WORLD
        ''')
        shell('''
        echo 'This is a test' > data.txt
        ''')
        shell('''
        echo 'This is a test' > dataTest.txt
        ''')
    }
    publishers {
        allure(['allure-results-combined']) {
        // Bracket body is needed!
        }
        archiveArtifacts {
            pattern('**/data.txt', 'allure-report.zip', '**/dataTest.txt')
            allowEmpty(true)
        }
    }
}
