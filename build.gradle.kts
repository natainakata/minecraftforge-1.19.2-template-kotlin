
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.Instant

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.21"
    id("net.minecraftforge.gradle")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
}

val archivesBaseName = "examplemod"

group = "io.github.natainakata"

version = "0.1.0"

val mcVersion = "1.19.2"
val forgeVersion = "43.2.14"
val kffVersion = "3.12.0"

println(
    "Java: " +
            System.getProperty("java.version") +
            "JVM: " +
            System.getProperty("java.vm.version") +
            "(" +
            System.getProperty("java.vendor") +
            ") Arch: " +
            System.getProperty("os.arch")
)

minecraft {
    this.mappings(mapOf("channel" to "official", "version" to mcVersion))
    this.runs {
        create("client") {
            workingDirectory(project.file("run"))

            property("forge.logging.markers", "REGISTRIES")
            property("forge.logging.console.level", "debug")

            property("mixin.env.remapRefMap", "true")
            property("mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")

        }
        create("server") {
            workingDirectory(project.file("run-server"))

            property("forge.logging.markers", "REGISTRIES")
            property("forge.logging.console.level", "debug")
            property("mixin.env.remapRefMap", "true")
            property("mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")
        }
        create("data") {
            workingDirectory(project.file("run"))

            property("forge.logging.markers", "REGISTRIES")
            property("forge.logging.console.level", "debug")
            property("mixin.env.remapRefMap", "true")
            property("mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")

            args("--mod", "examplemod", "--all", "--output", file("src/generated/resources/"), "--existing", file("src/main/resources"))
        }

    }
}

repositories {
    maven {
        name = "Kotlin for Forge"
        url = uri("https://thedarkcolour.github.io/KotlinForForge/")
        content { includeGroup("thedarkcolour") }
    }
}

dependencies {
    minecraft("net.minecraftforge:forge:$mcVersion-$forgeVersion")
    implementation("thedarkcolour:kotlinforforge:$kffVersion")
}

tasks {
    val javaVersion = JavaVersion.VERSION_17
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        options.release.set(javaVersion.toString().toInt())
    }
    withType<KotlinCompile> { kotlinOptions { jvmTarget = javaVersion.toString() } }
    withType<Jar> {
        manifest {
            attributes(
                mapOf(
                    "Spacifacation-Title" to "examplemod",
                    "Spacifacation-Vendor" to "natainakata",
                    "Spacifacation-Version" to "0",
                    "Implementation-Title" to project.name,
                    "implementation-Version" to version,
                    "Implementation-Vendor" to "natainakata",
                    "Implementation-Timestamp" to Instant.now().toString()
                )
            )
        }
        finalizedBy("reobfJar")
    }
    java {
        toolchain { languageVersion.set(JavaLanguageVersion.of(javaVersion.toString())) }
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
        withSourcesJar()
    }
}
