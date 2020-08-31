package net.inherency.example.core.exception

import net.inherency.example.Person
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

//RESULT is a lot like TRY; it wraps and simplifies the idea of expressing the need to handle exceptional behavior.
//For better or worse, RESULT only expresses the generic type associated with success.  Failures can be any subclass
//exception of Throwable type.
class ResultTest {

    @Test
    fun `RESULT is a wrapper for success or failure where success is a generic type`() {
        val person = Person("Scotty", 38, emptyList())
        val result = Result.success(person)

        assertEquals(person, result.getOrThrow())
        assertTrue(result.isSuccess)
        assertFalse(result.isFailure)
    }

    @Test
    fun `RESULT is a wrapper for success or failure where failure is an exception that we choose`() {
        val result = Result.failure<Person>(IllegalFormatFlagsException("Some rarely seen exception"))

        assertTrue(result.exceptionOrNull() is IllegalFormatFlagsException)
        assertTrue(result.isFailure)
        assertFalse(result.isSuccess)
    }

    @Test
    fun `RESULT fold is a fancy conditional map over success and failure where only success is used for success condition`() {
        val person = Person("Scotty", 38, emptyList())
        val result = Result.success(person)

        val fold = result.fold(
                { it.age * 2 },
                { 0 }
        )

        assertEquals(76, fold)
    }

    @Test
    fun `RESULT fold is a fancy conditional map over success and failure where only failure is used for fail condition`() {
        val result = Result.failure<Person>(IllegalArgumentException("..."))

        val fold = result.fold(
                { it.age * 2 },
                { 0 }
        )

        assertEquals(0, fold)
    }

}