package net.inherency.example.core.toplevelfunction.exception

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RequireTest {

    @Test
    fun `REQUIRE throws IllegalArgumentException when condition is not met`() {
        assertThrows<IllegalArgumentException> {
            require(false)
        }
    }

}