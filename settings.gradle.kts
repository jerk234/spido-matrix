pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven{
            url = uri("https://jitpack.io")
        }
        maven{
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        maven {
            url = uri("https://maven.google.com")
        }
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        // Do not use `mavenCentral()`, it prevents Dependabot from working properly
        maven {
            url = uri("https://repo1.maven.org/maven2")
        }
    }
}

rootProject.name = "spido"
include(":app")
include(":app:step-detector")
