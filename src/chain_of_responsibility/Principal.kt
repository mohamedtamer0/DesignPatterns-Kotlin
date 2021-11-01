package chain_of_responsibility

class Principal: Handler() {
    override fun capital(): Int {
        return 1000
    }

    override fun handle(money: Int) {
        println("Approved by the principal: approved $money Dollar")
    }
}