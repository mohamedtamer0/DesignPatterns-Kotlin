package Behavioraldesignpatterns.chain_of_responsibility

abstract class Handler {
    var successor: Handler? = null

    abstract fun capital(): Int
    abstract fun handle(money: Int)
    fun handleRequest(money: Int) {
        if (money <= capital()) {
            handle(money)
        } else {
            if (null != successor) {
                successor!!.handleRequest(money)
            } else {
                println("Your requested funds could not be approved")
            }
        }
    }
}