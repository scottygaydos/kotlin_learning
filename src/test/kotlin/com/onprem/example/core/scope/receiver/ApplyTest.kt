package com.onprem.example.core.scope.receiver

import com.onprem.example.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

//APPLY is a scope function using the object as a receiver.
//Thus, it refers to the object as 'this'.
//APPLY is good at assigning things.  When using APPLY, think:
//"apply the following assignments to the object."
class ApplyTest {

    @Test
    fun `APPLY assigns or mutates values in an object with an explicit use of THIS keyword`() {
        val person = Person("Scotty", 37).apply {
            this.age = 38
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

}
