package Structuraldesignpatterns.flyweight

import java.util.concurrent.ConcurrentHashMap


object TicketFactory {
    private val map: MutableMap<String, Ticket> = ConcurrentHashMap()
    fun getTicket(movieName: String): Ticket? {
        return if (map.containsKey(movieName)) {
            map[movieName]
        } else {
            val ticket: Ticket = MovieTicket(movieName)
            map[movieName] = ticket
            ticket
        }
    }
}
