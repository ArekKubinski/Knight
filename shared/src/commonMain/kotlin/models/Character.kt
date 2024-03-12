package models

import abstracts.Entity
import datas.Stats

data class Character(
    private val baseStats: Stats
): Entity(baseStats) {

}