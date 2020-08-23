package net.inherency.example.core.scope.argument

import net.inherency.example.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

//LET is probably the most popular scope function.  Expect to see it used on nullable object types
//as an implicit IF check
//LET is a scope function using the object as an argument that returns the lambda result.
//Thus, it refers to the object as 'it'.
//LET is used as an extension function.
class LetTest {

    @Test
    fun `LET calls a function block using object as argument and returns result`() {
        val scotty = Person("Scotty", 37)

        val birthdayMessage = scotty.let {
            "Happy birthday ${it.name}. You are ${it.age + 1} today!"
        }

        assertEquals("Happy birthday Scotty. You are 38 today!", birthdayMessage)
    }

    @Test
    fun `LET on a null object does nothing in the lambda when the safety check is on LET`() {
        val nullPerson: Person? = null
        var counter = 0

        nullPerson?.let {
            val ignored = it.age + 1
            counter += 1
            ignored
        }

        assertEquals(0, counter)
    }

    @Test
    fun `LET on a null object executes the lambda when the safety check is inside LET`() {
        val nullPerson: Person? = null
        var counter = 0

        nullPerson.let {
            val ignored = it?.age?.plus(1)
            counter += 1
            ignored
        }

        assertEquals(1, counter)
    }

    //This is probably bad by convention.
    @Test
    fun `LET calls a function block using object as argument and CAN mutate it (but we should not do this!)`() {
        val scotty = Person("Scotty", 37)

        scotty.let {
            //Calling this age setter probably bad by convention.
            it.age = it.age + 1
            "Happy birthday ${it.name}. You are ${it.age} today!"
        }

        //Because LET returns the birthday message, we should not mutate the age in the block.
        //See ALSO for a better mutate option.
        assertEquals(38, scotty.age)
    }

    @Test
    fun `LET calls a function block on null objects and executes the function block regardless`() {
        val nullPerson: Person? = null

        val birthdayMessage = nullPerson.let {
            "Happy birthday $it."
        }

        assertEquals("Happy birthday null.", birthdayMessage)
    }

    //This is probably bad by convention.
    @Test
    fun `LET calls a function block on null objects and can modify variables`() {
        val nullPerson: Person? = null
        var shouldChange = 0

        nullPerson.let {
            shouldChange++
        }

        assertEquals(1, shouldChange)
    }
}
