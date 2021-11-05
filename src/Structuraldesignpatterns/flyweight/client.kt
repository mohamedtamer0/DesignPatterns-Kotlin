package Structuraldesignpatterns.flyweight

fun main() {
    val movieTicket1 = TicketFactory.getTicket("Transformers 5") as MovieTicket
    movieTicket1.printTicket("14:00-16:30", "Seat  D-5")
    val movieTicket2 = TicketFactory.getTicket("Transformers 5") as MovieTicket
    movieTicket2.printTicket("14:00-16:30", "Seat  F-6")
    val movieTicket3 = TicketFactory.getTicket("Transformers 5") as MovieTicket
    movieTicket3.printTicket("18:00-22:30", "Seat  A-2")
}