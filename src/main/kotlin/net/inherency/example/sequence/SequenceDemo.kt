package net.inherency.example.sequence

fun demoGenerateSequence() {
    println("demoGenerateSequence")
    data class FibonacciState(var currentValue: Int = 0, var nextValue: Int = 1) {
        override fun toString(): String {
            return currentValue.toString()
        }
    }
    val state = FibonacciState()

    val fibonacciSequence = generateSequence(state) {
        val newValue = state.currentValue + state.nextValue
        state.currentValue = state.nextValue
        state.nextValue = newValue
        state
    }

    println(fibonacciSequence) //No good way to represent as string... so we get address output
    println(fibonacciSequence.filter { it.currentValue < 100 }) //non-terminal, so still a sequence

    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233
    val fibonacciOddValueAboveOneHundred = fibonacciSequence.filter { it.currentValue % 2 != 0 } //non-terminal
            .first { it.currentValue > 100 } //terminal

    println(fibonacciOddValueAboveOneHundred)

    val secondFibonacciSequence = generateSequence(Pair(0, 1)) {
        Pair(
                it.second,
                it.first + it.second
        )
    }

    //Goal: get all values from beginning to the first odd value above 100 inclusive.

    //don't do this!  filter is not limiting.
    //println(secondFibonacciSequence.filter { it.currentValue < fibonacciOddValueAboveOneHundred.currentValue }.toList())

    //Do this instead.  takeWhile is limiting, so final list has a way to complete.
    println(secondFibonacciSequence
            .takeWhile { it.first <= fibonacciOddValueAboveOneHundred.currentValue }
            .map { it.first }
            .toList())

    //Or... there is another way to generate a sequence using yield
    fun fibonacciOddValueAboveOneHundredUsingYield() = sequence {
        var terms = Pair(0, 1)

        // this sequence is infinite
        while (true) {
            //BUT... the sequence yields here instead of returning something
            yield(terms.first)
            terms = Pair(terms.second, terms.first + terms.second)
        }
    }

    val toList = fibonacciOddValueAboveOneHundredUsingYield()
            .takeWhile { it <= fibonacciOddValueAboveOneHundred.currentValue } //nice because the pair is completely hidden inside the sequence
            .toList()
    println(toList)
}