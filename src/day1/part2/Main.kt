package day1.part2

import day1.fileToArray

fun main(args: Array<String>) {
    val frequencies: ArrayList<Int> = fileToArray()
    val fake = arrayListOf<Int>(3, 3, 4, -2, -4)
    val resultingFrequency: Int = computeFrequencyTwo(frequencies)
    println(resultingFrequency)
}

fun computeFrequencyTwo(frequencies: ArrayList<Int>): Int {
    val resultingFrequencies: ArrayList<Int> = arrayListOf(0)
    var resultingFrequency = 0
    while (true) {
        frequencies.forEach {
            resultingFrequency += it
            if(hasAlreadyBeenReached(resultingFrequency, resultingFrequencies)) {
                return resultingFrequency
            }
            resultingFrequencies.add(resultingFrequency)
        }
    }
}

fun hasAlreadyBeenReached(frequency: Int, registeredFrequencies: ArrayList<Int>): Boolean = registeredFrequencies.contains(frequency)
