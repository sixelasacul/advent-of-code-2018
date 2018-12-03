package day1

import java.io.File

fun fileToArray(): ArrayList<Int> {
    val list: ArrayList<Int> = arrayListOf()
    File("./src/day1/input.txt").forEachLine { list.add(it.toInt()) }
    return list
}
