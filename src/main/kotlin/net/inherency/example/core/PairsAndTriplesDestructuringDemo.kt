package net.inherency.example.core

import net.inherency.example.Person

private fun personNameAndAge(person: Person): Pair<String, Int> {
    return Pair(person.name, person.age)
}

private fun personNameAndAgeAndEmail(person: Person): Triple<String, Int, String?> {
    return Triple(person.name, person.age, person.emailList.firstOrNull())
}

fun demoPairsAndTriplesAndDestructuring(): Person {
    val scotty = Person("Scotty", 38, listOf("scottygaydos@onprem.com"))

    println("demo double")
    val (pairName, pairAge) = personNameAndAge(scotty)
    println(pairName.trim())
    println(pairAge.times(1))

    println("demo triple")
    val (tripleName, tripleAge, tripleEmail) = personNameAndAgeAndEmail(scotty)
    println(tripleName.trim())
    println(tripleAge.times(1))
    println(tripleEmail.orEmpty())
    return scotty
}