package net.inherency.example.contracts

import net.inherency.example.Person
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun demoContracts() {
    demoObjectNotNullUsingContracts()
    demoObjectPropertyNotNull()
    demoTypeCastingContract()
}

@OptIn(ExperimentalContracts::class)
private fun demoObjectNotNullUsingContracts() {
    println("demoObjectNotNullUsingContracts")
    val nullablePerson: Person? = Person("Scotty", 38)

    //If we validate without a contract, we don't get smart casting
    validatePersonWithoutContract(nullablePerson)
    //println("${nullablePerson.name} is not null")  // This won't compile!
    println("${nullablePerson?.name} is not null (checked without contract)")

    //When we add a contract, we get smart casting!  Look at the highlight in IntelliJ
    validatePersonWithContract(nullablePerson)
    println("${nullablePerson.name} is not null (checked with contract)")
    println()
}

private fun validatePersonWithoutContract(person: Person?) {
    requireNotNull(person)
    require(person.name == "Scotty")
    require(person.age > 21)
    //etc
}

@ExperimentalContracts
private fun validatePersonWithContract(person: Person?) {
    contract {returns() implies (person != null)}
    //Now do other validations...
    requireNotNull(person)
    require(person.name == "Scotty")
    require(person.age > 21)
    //etc
}

@OptIn(ExperimentalContracts::class)
private fun demoObjectPropertyNotNull() {
    println("demoObjectPropertyNotNull")
    val nullablePerson: Person? = Person(name = "Scotty", age = 38, nickname = "Scootles ")
    validatePersonWithContract(nullablePerson)
    validatePersonNickName(nullablePerson.nickname)
    println("${nullablePerson.name} has nickname ${nullablePerson.nickname.trim()}" )
    println()
}

@ExperimentalContracts
//We cannot pass in the the Person and validate the property inside of the Person; we must pass in the property directly
//We cannot declare more than one contract inside the function
private fun validatePersonNickName(nickname: String?) {
    contract {returns() implies (nickname != null)}
    requireNotNull(nickname)
}

@OptIn(ExperimentalContracts::class)
private fun demoTypeCastingContract() {
    println("demoTypeCastingContract")
    val arrayList: List<Int> = arrayListOf(1, 2, 3)
    validateIsArrayList(arrayList)
    arrayList.add(4) //Suddenly, we can add items to the List
}



@ExperimentalContracts
private fun validateIsArrayList(arrayList: List<Int>) {
    contract {returns() implies (arrayList is ArrayList<Int>)}
    require(arrayList is List<Int>)
}