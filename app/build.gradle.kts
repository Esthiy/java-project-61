group = "hexlet.code"
version = "1.0-SNAPSHOT"

plugins {
    id("java")
    application
}

application {
    mainClass.set("hexlet.code.App")
}

tasks.withType<JavaCompile> {
    options.release = 20
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
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