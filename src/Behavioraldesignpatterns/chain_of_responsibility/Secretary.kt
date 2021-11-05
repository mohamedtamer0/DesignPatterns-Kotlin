package Behavioraldesignpatterns.chain_of_responsibility

class Secretary:Handler() {
    override fun capital(): Int {
        return 1000
    }

    override fun handle(money: Int) {
        println("Secretary approved: approved $money Dollar")
    }
}