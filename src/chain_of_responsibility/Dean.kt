package chain_of_responsibility

class Dean:Handler() {
    override fun capital(): Int {
        return 5000
    }

    override fun handle(money: Int) {
        println("Dean approved: approved $money Dollar")
    }
}