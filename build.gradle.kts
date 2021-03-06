plugins {
    kotlin("jvm") version "1.4.0"
    `maven-publish`
}

group = "com.github.noonmaru"
version = "0.3.1"

repositories {
    mavenCentral()
    maven(url = "https://papermc.io/repo/repository/maven-public/") //paper
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8")) //kotlin
    compileOnly("junit:junit:4.12") //junit
    compileOnly("com.destroystokyo.paper:paper-api:1.13.2-R0.1-SNAPSHOT") //paper
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    create<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }
}

publishing {
    publications {
        create<MavenPublication>("Kommand") {
            artifactId = project.name
            from(components["java"])
            artifact(tasks["sourcesJar"])
        }
    }
}