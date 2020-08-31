package net.inherency.example

data class Person (
        val name: String,
        var age: Int,
        val emailList: List<String> = emptyList()
)
