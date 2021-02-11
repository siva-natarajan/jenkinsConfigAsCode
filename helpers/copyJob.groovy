import hudson.model.*

for (item in Hudson.instance.items) {
    jobToBeCopied = ('cucumber_browser_tests.groovy').replaceAll('.groovy', '')
    println jobToBeCopied
    duplicateJobName = "$jobToBeCopied-duplicate"
    println duplicateJobName
    if (item.name == jobToBeCopied) {
        println 'COPYHAPPENING'
        Hudson.instance.copy(item, duplicateJobName).save()
    }
}
