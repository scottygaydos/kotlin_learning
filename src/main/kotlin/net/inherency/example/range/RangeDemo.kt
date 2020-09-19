package net.inherency.example.range

import net.inherency.example.Person

fun demoIntRange() {
    println("demoIntRange")
    val rangeTo = 1.rangeTo(10)
    println(rangeTo)

    //int, long, char ranges are arithmetic progressions and can be treated as such Iterable as a result
    rangeTo.onEach { print("$it ") }
    println()
    println(rangeTo.filter { it %2 == 0 }.sum()) // 2 + 4 + 6 + 8 + 10 = 30

    println()
}

fun demoCustomRange() {
    println("demoCustomRange")
    //custom ranges are not arithmetic progressions, so their functions are much more limited, but still useful
    val person1 = Person("Arry", 20)
    val person2 = Person("Zeph", 90)
    val wideRange = person1.rangeTo(person2)
    val altSyntaxWideRange = person1..person2

    val personInMiddle = Person("Georgina", 40)

    println(wideRange.contains(personInMiddle))
    println(personInMiddle in altSyntaxWideRange) //Sweet new infix operator!

    val yakko = Person("Yakko", 36)
    val dot = Person("Dot", 30)
    //range is unbreakable because Yakko > Wakko due to age
    val goodLuckBreakingThisRange = yakko.rangeTo(dot)
    println( Person("Wakko", 33) in goodLuckBreakingThisRange)
    println()
}

fun demoLoopOverRange() {
    println("demoLoopOverRange")
    for (i in 1..10) print("$i ")
    println()

    for (i in 20 downTo 10) print("$i ")
    println()

    for (i in 30..40 step 2) print("$i ")
    println()
}