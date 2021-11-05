package Behavioraldesignpatterns.state

class GameStartState : GameState {
    override fun killMonster() {
        println("Kill a Monster")
    }


    override fun gainExperience() {
        println("Gain 5 EXP")
    }


    override operator fun next() {
        println("Good! please enter next level")
    }


    override fun pick() {
        println("Wow! You pick a good thing")
    }
}