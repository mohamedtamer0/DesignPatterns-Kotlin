package state

fun main() {
    val player = Player()
    player.gameStart()
    player.killMonster()
    player.gainExperience()
    player.next()
    player.pick()
    player.gameOver()
    player.next()
    player.killMonster()
    player.pick()
}