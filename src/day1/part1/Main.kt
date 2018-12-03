package day1.part1

import day1.fileToArray

fun main(args: Array<String>) {
    val frequencies: ArrayList<Int> = fileToArray()
    val fake = arrayListOf<Int>(3, 3, 4, -2, -4)
    val resultingFrequency: Int = computeFrequencyOne(frequencies)
    println(resultingFrequency)
}

fun computeFrequencyOne(frequencies: ArrayList<Int>): Int = frequencies.sum()
