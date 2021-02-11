#!/usr/bin/env groovy
import hudson.model.*

for (item in Hudson.instance.items) {
    println jobNames
    jobToBeCopied = 'new'
    duplicateJobName = 'newDuplicacy'
    if (item.name == jobNames) {
        Hudson.instance.copy(item, duplicateJobName).save()
    }
}
