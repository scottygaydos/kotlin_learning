package net.inherency.example.core.scope.receiver

import net.inherency.example.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

//RUN is a scope function using the object as a receiver.
//Thus, it refers to the object as 'this'.
//RUN is kind of like LET, but uses a receiver instead of an argument.
//RUN does return the result of the lambda when used as an extension function.
//RUN can also be used as a top level function to assign the result of a
//block statement.
class RunTest {

    @Test
    fun `RUN can be used to anonymously group and execute a number of expressions or functions and assign the result`() {
        val output = run {
            var counter = 0
            counter *= 2
            counter += 1
            counter
        }

        assertEquals(1, output)
    }

    @Test
    fun `RUN can be used as an extension function that returns the lambda result`() {
        val newAge = Person("Scotty", 37).run {
            val output = age + 1
            output
        }

        assertEquals(38, newAge)
    }

}
