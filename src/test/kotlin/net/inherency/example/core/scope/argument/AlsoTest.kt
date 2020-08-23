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
    fun `ALSO calls a function block using object as argument and returns thee object itself`() {
        val scotty = Person("Scotty", 37)

        val result = scotty.also {
            it.age = it.age + 1
            "Happy birthday ${it.name}. You are ${it.age} today!" //useless!
        }

        //ALSO does not return the message!
        Assertions.assertEquals("Person(name=Scotty, age=38)", result.toString())
    }

    @Test
    fun `ALSO calls a function block using object as argument and CAN mutate it`() {
        val scotty = Person("Scotty", 37)

        scotty.also {
            it.age = it.age + 1
        }

        Assertions.assertEquals(38, scotty.age)
    }

    @Test
    fun `ALSO calls a function block on null objects and executes the function block regardless`() {
        val nullPerson: Person? = null

        val stillTheNullPerson: Person? = nullPerson.also {
            "Happy birthday $it." //This is highlighted by IntelliJ because it is never used.
        }

        //This is really nice!  Kotlin allows toString() on a null object,
        //and kotlin doesn't throw an exception!
        Assertions.assertEquals("null", stillTheNullPerson.toString())
    }

    //This is probably bad by convention.
    @Test
    fun `ALSO calls a function block on null objects and can modify variables`() {
        val nullPerson: Person? = null
        var shouldChange = 0

        nullPerson.also {
            shouldChange++
        }

        Assertions.assertEquals(1, shouldChange)
    }

}
