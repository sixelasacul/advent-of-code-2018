package day2

import java.io.File

fun fileToArray(): ArrayList<String> {
    val list: ArrayList<String> = arrayListOf()
    File("./src/day2/input.txt").forEachLine { list.add(it) }
    return list
}
