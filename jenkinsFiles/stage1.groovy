def stageOne() {
    parallel {
        stage('stageOne') {
            steps {
                sh('''
                        echo HELLO WORLD stage1
                        ''')
            }
        }
    }
}

return this
