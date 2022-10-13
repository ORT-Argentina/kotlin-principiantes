package com.ort.edu.challengepractica

/**
 * Como en este caso no hay un login real implementado, simplemente guardamos el nombre de usuario ingresado en el login
 * en una variable dentro de un Object. Un Object es una clase que equivale a un singleton de Java.
 * Documentación : https://kotlinlang.org/docs/object-declarations.html
 */
object UserSession {
    var userName: String? = null
}
