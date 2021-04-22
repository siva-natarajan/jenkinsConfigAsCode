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
            pattern('**/data.txt')
            pattern('allure-report.zip')
            pattern('**/dataTest.txt')
            allowEmpty(true)
        }
        logParser {
            useProjectRule(false)
            failBuildOnError(true)
            unstableOnWarning(true)
            projectRulePath('')
            parsingRulesPath('/var/jenkins_home/logParserRules.txt')
        }
    }
}
