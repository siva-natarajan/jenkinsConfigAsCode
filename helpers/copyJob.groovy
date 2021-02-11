#!/usr/bin/env groovy
import hudson.model.*

for (item in Hudson.instance.items) {
    def command = 'git diff-tree --no-commit-id --name-only -r -m HEAD jobs/*.groovy'
    def proc = command.execute()
    proc.waitFor()
    println "Process exit code: ${proc.exitValue()}"
    println "Std Err: ${proc.err.text}"
    println "Std Out: ${proc.in.text}"
    println "${ CHANGED_FILES }"
    println env.CHANGED_FILES
    def build = this.getProperty('binding').getVariable('build')
    def listener = this.getProperty('binding').getVariable('listener')
    def env = build.getEnvironment(listener)
    println env.CHANGED_FILES

    jobToBeCopied = 'new'
    duplicateJobName = 'newDuplicacy'
    if (item.name == 'jobNames') {
        Hudson.instance.copy(item, duplicateJobName).save()
    }
}
