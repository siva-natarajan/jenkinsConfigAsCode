#!/usr/bin/env groovy
import hudson.model.*

for (item in Hudson.instance.items) {
    if (item.name == 'new') {
        // print out everything about a project object:
        def job = Hudson.instance.copy(item, 'newDuplicate')
        job.save()
    }
}
