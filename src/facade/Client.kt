package facade

fun main() {
    val menu = Menu()
    println("Customer order")
    menu.lasagneWithTomatoAndCheese()
    menu.creamCaramel()

    println("===========New Order==========")
    println("Customer two orders")
    menu.bouillabaisse()
    menu.prawnRisotto()

}