package abstracts

import interfaces.Effect
import datas.Stats

abstract class Character {
    private val _activeEffects: MutableList<Effect> = mutableListOf()
    val activeEffects: List<Effect> get() = _activeEffects
    val stats: Stats
        get() {
            var tempStats = Stats()
            activeEffects.forEach {
                tempStats + it.change
            }
            return tempStats
        }

    fun applyEffect(effect: Effect) {
        _activeEffects.add(effect)
    }
}