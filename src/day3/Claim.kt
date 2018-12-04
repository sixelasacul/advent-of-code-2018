package day3

class Claim(val id: Int, val x: Int, val y: Int, val width: Int, val height: Int) {
    val positions: ArrayList<Pair<Int, Int>> = arrayListOf()

    val size: Int
        get() = this.width * this.height

    val outerX: Int
        get() = this.x + this.width

    val outerY: Int
        get() = this.y + this.height

    init {
        for(xP in this.x until this.outerX) {
            for(yP in this.y until this.outerY) {
                positions.add(Pair(xP, yP))
            }
        }
    }

    fun isOverlapping(other: Claim): Boolean {
        return this.isOverlappingOnX(other) && this.isOverlappingOnY(other)
    }

    fun isOverlappingOnX(other: Claim): Boolean {
        return when {
            other.x in this.x..this.outerX -> true
            other.outerX in this.x..this.outerX -> true
            other.x < this.x && this.outerX in this.x..this.outerX -> true
            other.outerX > this.outerX && this.x in this.x..this.outerX -> true
            other.x < this.x && other.outerX > this.outerX -> true
            else -> false
        }
    }

    fun isOverlappingOnY(other: Claim): Boolean {
        return when {
            other.y in this.y..this.outerY -> true
            other.outerY in this.y..this.outerY -> true
            other.y < this.y && this.outerY in this.y..this.outerY -> true
            other.outerY > this.outerY && this.y in this.y..this.outerY -> true
            other.y < this.y && other.outerY > this.outerY -> true
            else -> false
        }
    }

    fun getOverlappingPositions(other: Claim): ArrayList<Pair<Int, Int>> {
        val overlappingPositions: ArrayList<Pair<Int, Int>> = arrayListOf()
        this.positions.forEach {
            if(other.positions.contains(it)) {
                overlappingPositions.add(it)
            }
        }
        return overlappingPositions
    }
}
