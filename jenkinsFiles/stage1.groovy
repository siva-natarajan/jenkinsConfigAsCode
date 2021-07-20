def stageOne() {
    stage('stageOne') {
        steps {
            sh('''
                    echo HELLO WORLD stage1
                    ''')
        }
    }
}

return this
