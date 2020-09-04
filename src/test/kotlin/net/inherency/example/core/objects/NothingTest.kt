package net.inherency.example.core.objects

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.RuntimeException

class NothingTest {

    @Test
    fun `Nothing as a return type means the function will never return normally`() {
        assertThrows<RuntimeException> { thisFunctionCanOnlyThrowExceptions() }
    }

    private fun thisFunctionCanOnlyThrowExceptions(): Nothing {
        throw RuntimeException("thrown exception")
    }

}
