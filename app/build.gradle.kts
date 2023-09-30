group = "hexlet.code"
version = "1.0-SNAPSHOT"

plugins {
    id("java")
    application
}

tasks.withType<JavaCompile> {
    options.release = 20
}

application {
    mainClass.set("hexlet.code.App")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

tasks.test {
    useJUnitPlatform()
}