package interfaces

import datas.Stats

interface Effect {
    val name: String // name of effect
    val change: Stats
}