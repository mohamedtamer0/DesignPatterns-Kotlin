package Behavioraldesignpatterns.state

class GameOverState : GameState {
    override fun killMonster() {
        println("Please start game first")
    }

    override fun gainExperience() {}
    override operator fun next() {
        println("You want to challenge again?")
    }

    override fun pick() {
        println("Please start game first")
    }
}