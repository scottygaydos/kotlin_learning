package com.onprem.example.core.scope.argument

import com.onprem.example.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

//LET is a scope function using the object as an argument.
//Thus, it refers to the object as 'it'.
class LetTest {

    @Test
    fun `LET calls a function block using object as argument and returns result`() {
        val scotty = Person("Scotty", 37)

        val birthdayMessage = scotty.let {

            "Happy birthday ${it.name}. You are ${it.age + 1} today!"
        }

        assertEquals("Happy birthday Scotty. You are 38 today!", birthdayMessage)
    }

    //This is probably bad by convention.
    @Test
    fun `LET calls a function block using object as argument and CAN mutate it (but we should not do this!)`() {
        val scotty = Person("Scotty", 37)

        scotty.let {
            //This is bad by convention!  Don't do this!
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
