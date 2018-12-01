package day1

import java.io.File

fun main(args: Array<String>) {
    val frequencies: ArrayList<Int> = fileToArray("./src/day1/input.txt")
    val fake = arrayListOf<Int>(3, 3, 4, -2, -4)
    val resultingFrequency: Int = computeFrequencyTwo(frequencies)
    println(resultingFrequency)
}


fun fileToArray(pathname: String): ArrayList<Int> {
    val list: ArrayList<Int> = arrayListOf()
    File(pathname).forEachLine { list.add(it.toInt()) }
    return list
}

fun computeFrequencyOne(frequencies: ArrayList<Int>): Int {
    var resultingFrequency = 0
    frequencies.forEach { resultingFrequency += it }
    return resultingFrequency
}

fun computeFrequencyTwo(frequencies: ArrayList<Int>): Int {
    val resultingFrequencies: ArrayList<Int> = arrayListOf(0)
    var resultingFrequency = 0
    var continueToCompute = true
    while (continueToCompute) {
        frequencies.forEach {
            resultingFrequency += it
            if(hasAlreadyBeenReached(resultingFrequency, resultingFrequencies)) {
                continueToCompute = false
                return resultingFrequency
            }
            resultingFrequencies.add(resultingFrequency)
        }
    }
    return resultingFrequency
}

fun hasAlreadyBeenReached(frequency: Int, registeredFrequencies: ArrayList<Int>): Boolean = registeredFrequencies.contains(frequency)
