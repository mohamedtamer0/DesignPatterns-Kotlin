package flyweight

import java.util.*

class MovieTicket(private val movieName: String) : Ticket {
    private val price: String

    init {
        price = "Price " + Random().nextInt(100)
    }

    override fun printTicket(time: String?, seat: String?) {
        println("+-------------------+")
        System.out.printf("| %-12s    |\n", movieName)
        println("|                   |")
        System.out.printf("|       %-12s|\n", time)
        System.out.printf("|       %-12s|\n", seat)
        System.out.printf("|       %-12s|\n", price)
        println("|                   |")
        println("+-------------------+")
    }


}