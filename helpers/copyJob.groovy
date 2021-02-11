#!/usr/bin/env groovy
import hudson.model.*

for (item in Hudson.instance.items) {
    if (item.name == jobName) {
        Hudson.instance.copy(item, newDuplicacy).save()
    }
}
