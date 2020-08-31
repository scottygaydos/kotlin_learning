package net.inherency.example

import net.inherency.example.core.demoPairsAndTriplesAndDestructuring
import net.inherency.example.core.demoScopeFunctions

fun main() {
    val scopeFunctionDemoResult = demoScopeFunctions()
    println("scopeFunctionDemoResult: $scopeFunctionDemoResult")

    val pairsAndTriplesDestructuringResult = demoPairsAndTriplesAndDestructuring()
    println("pairsAndTriplesDestructuringResult: $pairsAndTriplesDestructuringResult")
}