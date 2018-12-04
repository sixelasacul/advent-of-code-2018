package day2.part2

import day2.fileToArray

//TODO: Comment code
//TODO: Optimize solution

fun main(args: Array<String>) {
    val boxIDs: ArrayList<String> = fileToArray()
    val fake: ArrayList<String> =
        arrayListOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")
    val fake2: ArrayList<String> =
        arrayListOf("aaaa", "bbbb", "aaaa", "abbb", "cdef")
    var result = compareBoxIDs(boxIDs)
    println(result)
}

fun compareBoxIDs(boxIDs: ArrayList<String>): ArrayList<String> {
    val scannedBoxIDs: ArrayList<String> = boxIDs.clone() as ArrayList<String>
    val correctBoxIDs: ArrayList<String> = arrayListOf()
    boxIDs.forEach {
        scannedBoxIDs.remove(it)
        val currentBoxID: String = it
        scannedBoxIDs.forEach {
            var possibleCorrectBoxID: String = ""
            when {
                currentBoxID == it -> {
                    possibleCorrectBoxID = currentBoxID
                }
                checkDifferencePosition(currentBoxID, it) -> {
                    possibleCorrectBoxID = removeDifferentCharacter(currentBoxID, it)
                }
            }
            if(!possibleCorrectBoxID.isEmpty() && !correctBoxIDs.contains(possibleCorrectBoxID)) {
                correctBoxIDs.add(possibleCorrectBoxID)
            }
        }
    }
    return correctBoxIDs
}

fun removeDifferentCharacter(first: String, second: String): String {
    var result: String = ""
    for(i in 0 until first.length) {
        if(first[i] == second[i])
            result += first[i]
    }
    return result
}

fun checkDifferencePosition(first: String, second: String): Boolean {
    var differences: Int = 0
    for(i in 0 until first.length) {
        if(first[i] != second[i])
            differences += 1
    }
    return differences <= 1
}
