/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("me.zepeto.creator.in_app_game.creator.kotlin-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
}

application {
    // Define the main class for the application.
    mainClass.set("me.zepeto.creator.in_app_game.creator.app.AppKt")
}
