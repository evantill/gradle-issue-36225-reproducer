
version="1.0.0"

val writeProperties = tasks.register<WriteProperties>("writeProperties") {
    property("version", project.provider{project.version})
    destinationFile.set(layout.buildDirectory.dir("write-properties").map { it.file("version.properties") })
}

//in some other place
writeProperties.configure {
    //setProperties should replace all properties
    setProperties("version" to project.version)
}
