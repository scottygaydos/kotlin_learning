package net.inherency.example.core.objects

import org.junit.jupiter.api.Test

class UnitTest {

    @Test
    fun `Unit in kotlin as a return object is equivalent to returning void`() {
        val x = returnNothing()
        println(x)
    }

    private fun returnNothing(): Unit { //Notice Unit return is not necessary
        val x = 1
        x.inc()
    }
}
