import hudson.model.*

for (item in Hudson.instance.items) {
    jobToBeCopied = 'cucumber_browser_tests.groovy'
    println jobToBeCopied
    duplicateJobName = '${jobsToBeCopied}-duplicate'
    println jobToBeCopied
    if (item.name == jobToBeCopied.replaceAll('.groovy', '')) {
        println "COPYHAPPENING"
        Hudson.instance.copy(item, duplicateJobName).save()
    }
}
