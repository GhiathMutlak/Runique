pluginManagement {
    includeBuild("build-logic")

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
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Runique"
include(":app")
include(":auth:presentation")
include(":auth:data")
include(":auth:domain")
include(":core:presentation:designsystem")
include(":core:presentation:ui")
include(":core:data")
include(":core:domain")
include(":core:database")
include(":run:data")
include(":run:presentation")
include(":run:domain")
include(":run:location")
include(":run:network")
