import hudson.model.*

for (item in Hudson.instance.items) {
    jobToBeCopied = 'cucumber_browser_tests.groovy'
    duplicateJobName = '${jobsToBeCopied}-duplicate'
    if (item.name == jobToBeCopied.replaceAll('.groovy', '')) {
        Hudson.instance.copy(item, duplicateJobName).save()
    }
}
