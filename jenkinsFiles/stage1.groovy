def stageOne() {
    stage('stage1') {
        steps {
            sh('''
                        echo HELLO WORLD stage1
                        ''')
        }
    }
}

return this
