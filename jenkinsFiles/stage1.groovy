def stageOne() {
    stage('stageOne') {
        when {
            expression {
                return true
            }
        }
        echo 'Hello World'
    }
}

return this
