package datas

data class Stats(
    val hp: Int = 0, // health points
    val mp: Int = 0, // mind points
) {

    operator fun plus(other: Stats) = Stats(
        hp + other.hp,
        mp + other.mp
    )
}