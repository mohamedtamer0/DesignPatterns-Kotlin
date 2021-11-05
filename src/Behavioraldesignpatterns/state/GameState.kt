package Behavioraldesignpatterns.state

interface GameState {
    fun killMonster()
    fun gainExperience()
    fun next()
    fun pick()
}
