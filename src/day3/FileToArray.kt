package day3

import java.io.File

fun fileToArray(): ArrayList<Claim> {
    val list: ArrayList<Claim> = arrayListOf()
    File("./src/day3/input.txt").forEachLine {
        val regex: Regex = Regex("#(\\d*) @ (\\d*),(\\d*): (\\d*)x(\\d*)")
        val matchingGroups: MatchResult? = regex.matchEntire(it)
        val grps: MatchGroupCollection = matchingGroups!!.groups
        val id: Int = grps[1]!!.value.toInt()
        val x: Int = grps[2]!!.value.toInt()
        val y: Int = grps[3]!!.value.toInt()
        val width: Int = grps[4]!!.value.toInt()
        val height: Int = grps[5]!!.value.toInt()
        val claim: Claim = Claim(id, x, y, width, height)
        list.add(claim)
    }
    return list
}
