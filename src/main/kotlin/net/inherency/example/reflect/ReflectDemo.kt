package net.inherency.example.reflect

import net.inherency.example.Person
import kotlin.reflect.safeCast

fun demoReflection() {
    demoKotlinClassVsJavaClass()
}

fun demoKotlinClassVsJavaClass() {
    println("demoKotlinClassVsJavaClass")
    val person = Person("Scotty", 38)
    val kClass = person::class //kotlin class
    val jClass = person::class.java //java class; use this for standard java reflection

    println(jClass.constructors)
    println(kClass.constructors)

    val otherPerson: Any = Person("Zeke", 30)
    println((kClass.safeCast(otherPerson)!!::class))

    val notPerson = kClass.safeCast(42)
    println(if (notPerson == null) "null" else notPerson::class)
    println()
}
