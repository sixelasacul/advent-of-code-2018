package day2.part1

import day2.fileToArray

//TODO: Comment code
//TODO: Optimize solution

fun main(args: Array<String>) {
    val boxIDs: ArrayList<String> = fileToArray()
    val fake: ArrayList<String> =
        arrayListOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")
    val fake2: ArrayList<String> =
        arrayListOf("aaabb", "bbbaa", "cccd", "abcde", "eee", "fdbba", "cccdbbaa")
    val result = computeChecksum(countRepetitions(boxIDs))
    println(result)
}

fun computeChecksum(repetitions: HashMap<Int, Int>): Int {
    var checksum: Int = 1
    repetitions.forEach {
        checksum *= it.value
    }
    return checksum
}

fun countRepetitions(boxIDs: ArrayList<String>): HashMap<Int, Int> {
    val countedRepetitions: HashMap<Int, Int> = hashMapOf()
    boxIDs.forEach {
        val repetitions: ArrayList<Int> = checkRepetitions(countLetters(it), arrayListOf(2, 3))
        repetitions.forEach {
            if (countedRepetitions.contains(it)) {
                countedRepetitions[it] = countedRepetitions[it]!! + 1
            } else {
                countedRepetitions[it] = 1
            }
        }
    }
    return countedRepetitions
}

fun checkRepetitions(
    repetitions: HashMap<Char, Int>,
    repetitionsToCount: ArrayList<Int>
): ArrayList<Int> {
    val encounteredRepetitions: ArrayList<Int> = arrayListOf()
    repetitions.forEach {
        val repetition: Int = it.value
        if (!encounteredRepetitions.contains(repetition) && repetitionsToCount.contains(repetition)) {
            encounteredRepetitions.add(repetition)
        }
    }
    return encounteredRepetitions
}

fun countLetters(boxID: String): HashMap<Char, Int> {
    val encounteredLetters: HashMap<Char, Int> = hashMapOf()
    boxID.forEach {
        if (encounteredLetters.contains(it)) {
            encounteredLetters[it] = encounteredLetters[it]!! + 1
        } else {
            encounteredLetters[it] = 1
        }
    }
    return encounteredLetters
}
