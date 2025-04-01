
group = "hexlet.code"
version = "1.0-SNAPSHOT"

plugins {
    id("java")
    id("application")
//    id("com.github.ben-manes.versions") // , version("$version"))
    id("com.github.ben-manes.versions") version "0.50.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

application { mainClass.set("hexlet.code.App") }


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}