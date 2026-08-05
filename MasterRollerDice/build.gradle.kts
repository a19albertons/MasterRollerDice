// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Librerias por defecto
    alias(libs.plugins.android.application) apply false

    // KSP procesa las anotacioones de Room
    alias(libs.plugins.ksp) apply false

    // Safe Args para pasar parametro de una clase a otra
    alias(libs.plugins.androidx.navigation.safeargs) apply false

    // Generación de documentación con Dokka
    alias(libs.plugins.kotlin.dokka)

    // Ktlint para formatear el código
    alias(libs.plugins.ktlint)
}
