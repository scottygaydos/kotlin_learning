package net.inherency.example.core.scope.argument

import net.inherency.example.Person
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//ALSO is a scope function using the object as an argument that also returns that object.
//Any implied lambda result is ignored.
//Thus, it refers to the object as 'it'.
//When using ALSO, think:
//"...and also do the following with the object"
class AlsoTest {

    @Test
    fun `ALSO is good for implementing desired side effects`() {
        val scotty = Person("Scotty", 37)

        val result = scotty.also {
            println("Happy birthday $scotty.  You are now ${scotty.age + 1}")
        }

    }

    @Test
    //I really wish also didn't allow mutation and didn't return anything.
    fun `ALSO calls a function block using object as argument and returns the object itself`() {
        val scotty = Person("Scotty", 37)

        val result = scotty.also {
            it.age = it.age + 1
            "Happy birthday ${it.name}. You are ${it.age} today!" //useless!
        }

        //ALSO does not return the message!  It returns the person... use APPLY for this instead.
        Assertions.assertEquals("Person(name=Scotty, age=38, emailList=[])", result.toString())
    }
}
