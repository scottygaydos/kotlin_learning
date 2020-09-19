@file:Suppress("unused")

package net.inherency.example

import net.inherency.example.collections.*
import net.inherency.example.core.demoPairsAndTriplesAndDestructuring
import net.inherency.example.core.demoScopeFunctions
import net.inherency.example.range.demoCustomRange
import net.inherency.example.range.demoIntRange
import net.inherency.example.range.demoLoopOverRange
import net.inherency.example.sequence.demoGenerateSequence

fun main() {
    //demoCore()()
    //demoCollections()

    demoRanges()
    demoSequences()
}

fun demoRanges() {
    demoIntRange()
    demoCustomRange()
    demoLoopOverRange()
    println()
}

fun demoSequences() {
    demoGenerateSequence()
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

fun demoCore() {
    val scopeFunctionDemoResult = demoScopeFunctions()
    println("scopeFunctionDemoResult: $scopeFunctionDemoResult")

    val pairsAndTriplesDestructuringResult = demoPairsAndTriplesAndDestructuring()
    println("pairsAndTriplesDestructuringResult: $pairsAndTriplesDestructuringResult")
}