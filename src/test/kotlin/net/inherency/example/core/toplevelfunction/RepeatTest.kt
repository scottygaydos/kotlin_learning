package net.inherency.example.core.toplevelfunction

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RepeatTest {

    @Test
    fun `REPEAT simplifies looping X number of times`() {
        var counter = 0
        repeat(5) {
            counter += 2
        }

        assertEquals(10, counter)
    }

}