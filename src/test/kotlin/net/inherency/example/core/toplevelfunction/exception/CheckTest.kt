package net.inherency.example.core.toplevelfunction.exception

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CheckTest {

    @Test
    fun `CHECK throws IllegalStateException when the condition is not met`() {
        assertThrows<IllegalStateException> {
            check(false)
        }
    }
}