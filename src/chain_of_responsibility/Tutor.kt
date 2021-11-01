package chain_of_responsibility

class Tutor:Handler() {
    override fun capital(): Int {
        return 100
    }

    override fun handle(money: Int) {
        println("Approved by the instructor: approved $money Dollar")
    }
}