@file:Suppress("unused")

package net.inherency.example.collections

@Suppress("UNUSED_VARIABLE")
fun demoOnEachVsForEach() {
    //Notice this list is of type Unit
    val list = listOf(1, 2, 3).forEach {
        print("$it ")
    }

    //Notice this list is is of the same type as the list used for onEach.
    val originalList = listOf(1, 2, 3).onEach {
        print("${it * 2} ")
    }

    println(originalList)
}

fun demoSortVsSorted() {
    //sort (in place) vs sorted
    mutableListOf(5, 4, 6).apply {
        sort()
        print("$this ")
    }

    listOf(5, 4, 6).sorted().also {
        print("$it ")
    }
}

fun demoWindowed() {
    val windowed = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).windowed(2, 1, false)
    println(windowed)
}

fun demoGrouping() {
    //groupingBy allows for values comprised of lists to be aggregated with accumulators using aggregate, fold, or reduce (traditional functional methods)
    //groupingBy returns Groupings instead of maps!
    val groupBy = listOf(1, 2, 3, 4).groupingBy { if(it % 2 == 0) "even" else "odd" }
    val groupByResult = groupBy.aggregate { _, accumulator: Int?, element, first ->
        if (first)
            element
        else
            accumulator!! + element
    }
    println(groupByResult)

    println(listOf(1, 2, 3, 4).groupingBy { if (it % 2 == 0) "even" else "odd" }.reduce { _, accumulator, element ->
        accumulator + element
    })

    //groupBy vs groupingBy vs associate
    //groupBy gives simple/basic/straight-forward implementations.
    val groupBy1 = listOf(1, 2, 3, 4).groupBy { if (it % 2 == 0) "even" else "odd" }
    println(groupBy1.mapValues { it.value.sum() })

    //associate takes each entry and maps it to a pair that comprises one entry in a resulting map.  Values are NOT added to a list.
    //goal: for a list of integers, get sum of all even values and sum of all odd values, and report as map output
    //example: listOf(1, 2, 3, 4) -> mapOf("odd" to 4, "even" to 6)
    //val associateBy = listOf(1, 2, 3, 4).associate { Pair(if (it % 2 == 0) "even" else "odd", it) }
    val associateBy = listOf(1, 2, 3, 4).associateBy { if (it % 2 == 0) "even" else "odd" } //same as line above
    println(associateBy) //oops!  Only took LAST value!
}

fun demoChunked() {
    //chunked -- split into list of lists not exceeding the given size
    listOf(1, 2, 3, 4, 5, 6).chunked(3).forEach {
        println(it)
    }
}

fun demoNullFriendlyArrayAndListGetters() {
    val arr = arrayOf(1, 2, 3)
    //val list = listOf(4, 5, 6) These all work for lists as well as arrays

    //typical
    println(arr[0])


    //oops!
    //println(arr[3])
    //println(list[3])


    //elementAtOrNull, elementAtOrElse
    println(arr.elementAtOrNull(3))
    //println(list.elementAtOrNull(3))

    //getOrNull, getOrElse
    println(arr.getOrElse(3) { -1 })
    //println(list.getOrElse(3) { -1 })
}

fun demoBasicCollections() {
    //immutable
    arrayOf(1, 2, 3)
    listOf(1, 2, 3)
    setOf(1, 2, 2)
    mapOf(
            1 to "1",
            2 to "2"
    )

    //mutable
    val mutableList = mutableListOf(0, 2)
    mutableList.add(3)
    mutableList[0] = 1
    println(mutableList)

    //mutableListOf, mutableSetOf, mutableMapOf are available, too...

    //functional approach instead
    val list = listOf(1, 2, 3)
    val longerList = list.plus(4)
    println(longerList)
    val originalList = longerList.minus(4)
    println(originalList)
}

fun demoBasicFunctionalApproaches() {
    val strings = listOf("1", "2", "3", "4")
    val ints = strings.map { it.toInt() }
    val oddNumbers = ints.filter { it % 2 != 0 }
    val sum = oddNumbers.reduce { acc: Int, next: Int -> acc + next }
    println(sum)

    val altSum = oddNumbers.foldRight(0){ acc: Int, next: Int -> acc + next }
    println(altSum)

    //There are many convenience functions, too
    println(oddNumbers.sum())
    println()
    println(oddNumbers.average())
    println(ints.runningReduce { acc: Int, next: Int -> acc + next })
    println(strings.joinToString())
}

@Suppress("UNUSED_VARIABLE")
fun demoFlatMapVsFlatten() {
    val listOfLists = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
    )

    @Suppress("SimplifiableCall")
    val flatMap = listOfLists.flatMap { it }
    val flatten = listOfLists.flatten()
    println(flatMap)
    println(flatten)
}

fun demoPartition() {
    val integers = listOf(1, 2, 3, 4, 5, 6)
    //val evensAndOdds = integers.partition { it % 2 == 0 }
    val (evens, odds) = integers.partition { it % 2 == 0 }
    println(evens)
    println(odds)
}
