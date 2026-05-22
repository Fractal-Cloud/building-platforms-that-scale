plugins {
    `java-library`
    `maven-publish`
}

group = "cloud.fractal"
version = "1.0.0"
description = "Simplified SDK project used in Fractal Architecture Book"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.apache.commons:commons-lang3:3.14.0")
    api("org.slf4j:slf4j-api:2.0.13")

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")

    testCompileOnly("org.projectlombok:lombok:1.18.42")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.42")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.2")
    testImplementation("org.junit-pioneer:junit-pioneer:2.2.0")
    testImplementation("org.assertj:assertj-core:3.26.0")
    testImplementation("com.flextrade.jfixture:jfixture:2.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(25)
    options.compilerArgs.add("--enable-preview")
    options.encoding = "UTF-8"
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    jvmArgs("--enable-preview")
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = false
    }
}

tasks.withType<Javadoc>().configureEach {
    (options as StandardJavadocDocletOptions).apply {
        addBooleanOption("-enable-preview", true)
        addStringOption("source", "25")
        addStringOption("Xdoclint:all,-missing", "-quiet")
        addBooleanOption("nohelp", true)
    }
    isFailOnError = false
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {
                name.set("${project.group}:${project.name}")
                description.set(project.description)
                url.set("https://github.com/Fractal-Cloud/building-platforms-that-scale")
                developers {
                    developer {
                        name.set("YanchWare")
                        email.set("hello@yanchware.com")
                        organization.set("YanchWare")
                        organizationUrl.set("https://yanchware.com/")
                    }
                }
            }
        }
    }
}
