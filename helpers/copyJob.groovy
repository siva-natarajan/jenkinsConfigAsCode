#!/usr/bin/env groovy
import hudson.model.*

for (item in Hudson.instance.items) {
    println jobName
    jobToBeCopied = 'new'
    duplicateJobName = 'newDuplicacy'
    if (item.name == jobName) {
        Hudson.instance.copy(item, duplicateJobName).save()
    }
}
