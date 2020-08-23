package net.inherency.example.core.infix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ToTest {

    @Test
    fun `TO is an infix operator that conveniently creates a pair`() {
        val outputMap = mapOf(
                1 to "one",
                2 to "two"
        )

        assertEquals("two", outputMap[2])
    }


}