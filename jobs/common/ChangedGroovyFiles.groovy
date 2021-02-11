package common

class ChangedGroovyFiles {

    @NonCPS
    static String changedFilesList() {
        changedFiles = []
        for (changeLogSet in currentBuild.changeSets) {
            for (entry in changeLogSet.getItems()) { // for each commit in the detected changes
                for (file in entry.getAffectedFiles()) {
                    changedFiles.add(file.getPath()) // add changed file to list
                }
            }
        }

        return "hello"
    }

}
