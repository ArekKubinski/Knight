class Dice(
    private val max: Int = 6,
    private val count: Int = 1,
    private val min: Int = 1,
    private val dropLowest: Int = 0,
    private val dropHighest: Int = 0
) : Number(), Comparable<Dice>, Iterable<Int> {
    private val array: IntArray = IntArray(count)
    var results: IntArray = results()
        private set
    var result: Int = result()
        private set

    init {
        if (dropLowest + dropHighest >= count)
            throw IllegalArgumentException("Sum of dropLowest and dropHighest can not be higher or equal to the count.")
        roll()
    }

    override fun toString(): String {
        return result.toString()
    }

    override fun hashCode(): Int {
        return results.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return this.hashCode() == other.hashCode()
    }

    fun roll(): Int {
        (0..<count).forEach {
            array[it] = (min..max).random()
        }
        results = results()
        result = result()

        return result
    }

    private fun result(): Int =
        results.sum()

    private fun results(): IntArray =
        array.sortedArrayDescending().sliceArray(dropLowest..<(count - dropHighest))

    override fun iterator(): IntIterator =
        array.sortedArrayDescending().sliceArray(dropLowest..<(count - dropHighest)).iterator()

    override fun compareTo(other: Dice): Int =
        result - other.result

    override fun toByte(): Byte =
        result.toByte()

    override fun toDouble(): Double =
        result.toDouble()

    override fun toFloat(): Float =
        result.toFloat()

    override fun toInt(): Int =
        result

    override fun toLong(): Long =
        result.toLong()

    override fun toShort(): Short =
        result.toShort()

}
