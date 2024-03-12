package abstracts

import interfaces.Effect
import datas.Stats

abstract class Entity(private val baseStats: Stats) {
    private val _activeEffects: MutableList<Effect> = mutableListOf()
    val activeEffects: List<Effect> get() = _activeEffects
    var dirtyFlag = true
        private set
    private var calculatedStats = stats
    val stats: Stats
        get() {
            if (dirtyFlag) {
                var tempStats = baseStats
                activeEffects.forEach {
                    tempStats += it.change
                }
                calculatedStats = tempStats
                dirtyFlag = !dirtyFlag
                return tempStats
            } else
                return calculatedStats
        }

    fun applyEffect(effect: Effect) {
        _activeEffects.add(effect)
        dirtyFlag = true
    }

    fun removeEffect(effect: Effect) = _activeEffects.remove(effect)
}