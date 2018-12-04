package day3.part1

import day3.Claim
import day3.fileToArray

// Challenge: https://adventofcode.com/2018/day/3
// How many square inches of fabric are within two or more claims?

//TODO: Comment code
//TODO: Find a more optimized way (by removing the positions ArrayList and just compute every time)

fun main(args: Array<String>) {
    val claims: ArrayList<Claim> = fileToArray()
    val fake: ArrayList<Claim> = arrayListOf(
        Claim(1, 1, 3, 4, 4),
        Claim(2, 3, 1, 4, 4),
        Claim(3, 5, 5, 2, 2))
    val fake2: ArrayList<Claim> = arrayListOf(
        Claim(1, 10, 13, 4, 4),
        Claim(2, 7, 10, 8, 5),
        Claim(3, 2, 12, 6, 5),
        Claim(4, 19, 14, 2, 12),
        Claim(5, 13, 4, 8, 9),
        Claim(6, 20, 20, 6, 5),
        Claim(7, 20, 20, 1, 4),
        Claim(8, 18, 1, 2, 2),
        Claim(9, 4, 14, 8, 7))
    val result = computeOverlappedPositions(claims)
    println(result.size)
}

fun computeOverlappedPositions(claims: ArrayList<Claim>): ArrayList<Pair<Int, Int>> {
    val overlappedPositions: ArrayList<Pair<Int, Int>> = arrayListOf()
    val claimsToCheck: ArrayList<Claim> = claims.clone() as ArrayList<Claim>
    claims.forEach {
        claimsToCheck.remove(it)
        val currentClaim: Claim = it
        claimsToCheck.forEach {
            if(currentClaim.isOverlapping(it)) {
                currentClaim.getOverlappingPositions(it).forEach {
                    if(!overlappedPositions.contains(it)) {
                        overlappedPositions.add(it)
                    }
                }
            }
        }
    }
    return overlappedPositions
}
