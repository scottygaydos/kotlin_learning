package net.inherency.example.core.scope.receiver

import net.inherency.example.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

//WITH is a scope function using the object as a receiver that returns the lambda result.
//Thus, it refers to the object as 'this'.
//WITH is interesting because it is not an extension function; it is a top level function.
//WITH is good for quick/clean mapping that reduces references to 'it'.  When using WITH, think:
//"With this object, do the following things..."
class WithTest {

    @Test
    fun `WITH returns the result of the lambda`() {
        val person = Person("Scotty", 37)

        val newAge = with(person) {
            age += 1
            age
            //This is a common kotlin pattern -- the last statement in a lambda is what is returned.
            //We do NOT use the return keyword explicitly because kotlin thinks we mean to return
            //the entire function, not just the inner lambda.  There are ways around this issue
            //if we desire to return sooner from a lambda using other keywords or by calling
            //explicitly named/created functions.
        }

        println(person)

        assertEquals(38, newAge)
    }

    @Test
    fun `WITH can help reduce variables and reference calls`() {
        val correctAge = with(Person("Scotty", 37).age) {
            when(this) {
                36 -> false
                37 -> true
                38 -> false
                else -> error("All other conditions are WAY off! Guess was $this years old")
            }
        }

        assertTrue(correctAge)
    }

}
