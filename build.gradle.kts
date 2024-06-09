import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile

plugins {
    kotlin("multiplatform") version "2.0.0"
}

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        browser {
        }
        binaries.executable()
    }

    sourceSets {
        named("jsMain") {
            dependencies {
                implementation(devNpm("tailwindcss", ">= 3.4"))
            }
        }
    }
}

tasks.withType<KotlinJsCompile>().configureEach {
    compilerOptions {
        target = "es2015"
    }
}

val tailwind by tasks.registering(Exec::class) {
    dependsOn("kotlinNpmInstall")

    val inputFile = file("src/tailwind/input.css")
    val configFile = file("src/tailwind/tailwind.config.js")
    val contentFile = file("src/jsMain/resources/index.html")
    val outputFile = file("build/output.css")
    inputs.file(inputFile)
    inputs.file(configFile)
    inputs.file(contentFile)
    outputs.file(outputFile)

    workingDir("build/js/packages")
    commandLine(
        "npx", "tailwind",
        "-i", inputFile,
        "-c", configFile,
        "--content", contentFile,
        "-o", outputFile,
        "-m" // minify
    )
}

tasks.named<ProcessResources>("jsProcessResources") {
    from(tailwind)
}
