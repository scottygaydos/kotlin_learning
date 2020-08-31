package net.inherency.example.core.toplevelfunction

import net.inherency.example.Person
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class TakeIfUnlessTest {

    @Test
    fun `TAKEIF is like a filter, but for a single object`() {
        val person = Person("Scotty", 38, emptyList())
        assertNull(takeIf { person.emailList.isNotEmpty() })
    }

    @Test
    fun `TAKEUNLESS is like a filter, but for a single object`() {
        val person = Person("Scotty", 38, emptyList())
        assertNull(takeUnless { person.emailList.isEmpty() })
    }

}