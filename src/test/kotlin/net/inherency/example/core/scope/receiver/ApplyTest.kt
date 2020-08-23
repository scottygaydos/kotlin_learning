package net.inherency.example.core.scope.receiver

import net.inherency.example.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

//APPLY is a scope function using the object as a receiver that returns the original object.
//Any lambda 'result' is ignored the original object is what is always returned.
//Thus, it refers to the object as 'this'.
//APPLY is good at assigning things.  When using APPLY, think:
//"apply the following assignments to the object."
class ApplyTest {

    @Test
    fun `APPLY assigns or mutates values in an object with an explicit use of THIS keyword`() {
        val person = Person("Scotty", 37).apply {
            this.age = 38 //age is not returned; the person is returned.
        }

        assertEquals(38, person.age)
    }

    @Test
    fun `APPLY assigns or mutates values in an object with an implicit use of THIS keyword`() {
        val person = Person("Scotty", 37).apply {
            age = 38
        }

        assertEquals(38, person.age)
    }

    @Test
    fun `APPLY on a null(able) object requires safety operator`() {
        val nullPerson: Person? = null
        var counter = 0

        //safety check inside; the inner block is executed as much as possible given nulls.
        nullPerson.apply {
            this?.age = 39
            println("first; this should print out")
            counter += 1
        }

        //one safety check outside; the whole inner block is skipped.
        nullPerson?.apply {
            age = 38
            println("second; this should not print out") //this will never print; see test output
            counter += 1
        }

        assertEquals(1, counter)
    }

}
