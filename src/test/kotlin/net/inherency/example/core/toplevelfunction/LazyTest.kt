package net.inherency.example.core.toplevelfunction

import net.inherency.example.Person
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LazyTest {

    @Test
    fun `LAZY makes lazily initialized things`() {
        val lazyPerson = lazy {
            Person("Scotty", 38)
        }

        assertFalse(lazyPerson.isInitialized())
    }

    @Test
    fun `LAZY initializes when we call get`() {
        val lazyPerson = lazy {
            Person("Scotty", 38)
        }

        lazyPerson.value

        assertTrue(lazyPerson.isInitialized())
    }

}