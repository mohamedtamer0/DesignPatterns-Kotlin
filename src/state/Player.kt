package state

class Player {
    private lateinit var state: GameState

    private fun setState(state: GameState?) {
        this.state = state!!
    }

    fun gameStart() {
        setState(GameStartState())
        println("\n-----Game Start, ready to fight-----\n")
    }

    fun gameOver() {
        setState(GameOverState())
        println("\n-----         Game Over        -----\n")
    }

    fun killMonster() {
        state.killMonster()
    }

    fun gainExperience() {
        state.gainExperience()
    }

    operator fun next() {
        state.next()
    }

    fun pick() {
        state.pick()
    }
}