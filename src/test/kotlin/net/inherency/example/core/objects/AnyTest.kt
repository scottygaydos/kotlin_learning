package net.inherency.example.core.objects

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AnyTest {

    @Test
    fun `Any is the Object equivalent in kotlin`() {
        val vagueList: List<Any> = listOf(1, "a", true, 5.5)
        assertEquals(4, vagueList.size)
    }

    @Test
    fun `Casting from Any uses AS keyword`() {
        val vagueList = listOf(1, "a", true, 5.5)
        assertTrue(vagueList[2] as Boolean)
    }
}
