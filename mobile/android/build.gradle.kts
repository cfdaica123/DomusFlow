allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

val newBuildDir: Directory =
    rootProject.layout.buildDirectory
        .dir("../../build")
        .get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}
subprojects {
    // Avoid forcing evaluation of :app during configuration to prevent SDK lookup errors.
    // If you need to depend on tasks from :app, use task dependencies or providers, e.g.:
    // tasks.named("someRootTask") {
    //     dependsOn(":app:someTask")
    // }
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
