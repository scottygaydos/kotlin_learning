package net.inherency.example.core.toplevelfunction.exception

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ErrorTest {

    @Test
    fun `ERROR will always throw an IllegalStateException just give it the desired message`() {
        assertThrows<IllegalStateException> {
            error("This throws an Exception")
        }
    }

}