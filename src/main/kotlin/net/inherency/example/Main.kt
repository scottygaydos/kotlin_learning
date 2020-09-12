@file:Suppress("unused")

package net.inherency.example

import net.inherency.example.collections.*
import net.inherency.example.core.demoPairsAndTriplesAndDestructuring
import net.inherency.example.core.demoScopeFunctions

fun main() {
    //demoCore()()

    demoCollections()
}

fun demoCore() {
    val scopeFunctionDemoResult = demoScopeFunctions()
    println("scopeFunctionDemoResult: $scopeFunctionDemoResult")

    val pairsAndTriplesDestructuringResult = demoPairsAndTriplesAndDestructuring()
    println("pairsAndTriplesDestructuringResult: $pairsAndTriplesDestructuringResult")
}

fun demoCollections() {
    demoBasicCollections()
    demoBasicFunctionalApproaches()
    demoOnEachVsForEach()
    demoSortVsSorted()
    demoPartition()
    demoFlatMapVsFlatten()
    demoNullFriendlyArrayAndListGetters()
    demoChunked()
    demoGrouping()
    demoWindowed()
}