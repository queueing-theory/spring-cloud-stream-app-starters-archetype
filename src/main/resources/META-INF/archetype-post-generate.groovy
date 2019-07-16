import groovy.io.FileType

import java.nio.file.Paths

def projectPath = Paths.get(request.outputDirectory, request.artifactId)
def configurationModule = "spring-cloud-starter-stream-${request.properties.appType}-${request.artifactId}"
def configuration = projectPath.resolve(configurationModule)

def create(File parent, String[] files) {
    if (files.length == 0) return parent
    File head = new File(parent, files.head())
    String[] tail = files.tail()
    return create(head, tail)
}

def dir = configuration.toFile()
def deleteTargets = []
def deleteTarget = null
def propertiesFiles = []
def propertiesType = null
dir.eachFileRecurse(FileType.ANY) { file ->
    if (file.isDirectory() && !file.name.endsWith('META-INF')) {
        if (file.name.contains('-')) {
            deleteTarget = file
            file = create(file.parentFile, file.name.split('-'))
            if (file.mkdirs()) {
                dir = file
            }
        } else if (deleteTarget != null && file.parentFile == deleteTarget) {
            dir = new File(dir, file.name)
            if (!dir.exists()) {
                dir.mkdir()
                deleteTargets << deleteTarget
            }
        } else {
            dir = file
        }
    } else if (file.name.endsWith('.java')) {
        def artifactId = (request.artifactId.contains('-')) ?
                request.artifactId.split('-').inject('') { result, word ->
                    result += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
                    result
                } : request.artifactId.substring(0, 1).toUpperCase() + request.artifactId.substring(1).toLowerCase()
        def appType = request.properties.appType.substring(0, 1).toUpperCase() + request.properties.appType.substring(1).toLowerCase()
        def renameTo = file.name.replace(request.artifactId, artifactId).replace(request.properties.appType, appType)
        File newFile = new File(dir, renameTo)
        if (newFile.name.endsWith('Properties.java')) {
            propertiesType = newFile.name
        }
        file.renameTo(newFile)
    } else if (file.name.endsWith('.properties')) {
        propertiesFiles << file
    }
}

if (!propertiesFiles.isEmpty()) {
    (propertiesFiles as File[]).each {
        it << '.' + propertiesType.take(propertiesType.lastIndexOf('.'))
    }
}

if (!deleteTargets.isEmpty()) {
    (deleteTargets as File[]).each {
        it.deleteDir()
    }
}

new File(projectPath.toFile(), 'velocity.vm').delete()
new File(projectPath.toFile(), 'mvnw').setExecutable(true)
new File(projectPath.toFile(), 'mvnw.cmd').setExecutable(true)


