group = "hexlet.code"
version = "1.0-SNAPSHOT"

plugins {
    id("java")
    id("application")
    id("checkstyle")
    id("com.github.ben-manes.versions") version "0.50.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("org.sonarqube") version "6.1.0.5360"
    id("jacoco")
}

sonar {
    properties {
        property("sonar.projectKey", "benissimoff_java-project-71")
        property("sonar.organization", "benissimoff")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

application { mainClass.set("hexlet.code.App") }

repositories {
    mavenCentral()
}

dependencies {
//    testImplementation(platform("org.junit:junit-bom:5.9.1"))

//    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("info.picocli:picocli:4.7.6")
    annotationProcessor("info.picocli:picocli-codegen:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-core:2.18.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.19.0-rc2")
}

//compileJava {
//    options.compilerArgs += ["-Aproject=${project.group}/${project.name}"]
//}

tasks.test {
    useJUnitPlatform()
//    testLogging {
//        exceptionFormat = TestExceptionFormat.FULL
//        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
//        // showStackTraces = true
//        // showCauses = true
//        showStandardStreams = true
//    }
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.required = true
    }
}