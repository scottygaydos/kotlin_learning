package net.inherency.example.core.toplevelfunction.exception

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RequireTest {

    @Test
    fun `REQUIRE throws IllegalArgumentException when condition is not met`() {
        assertThrows<IllegalArgumentException> {
            require(false)
        }
    }

    @Test
    fun `REQUIRENOTNULL also throws IllegalArgument exception when item is null, but also returns non-null value result`() {
        val nullableString: String? = "Not a null string         "
        assertEquals("Not a null string", requireNotNull(nullableString).trim()) // no null safety check needed
    }

}