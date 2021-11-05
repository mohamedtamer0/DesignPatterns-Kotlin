package Behavioraldesignpatterns.observer

fun main() {
    val magazine = Magazine()

    val mohamed = Subscriber(magazine, "Mohamed")
    val tamer = Subscriber(magazine, "Tamer")
    val habiba = Subscriber(magazine, "Habiba")
    val bookstore = Bookstore(magazine)

    magazine.setMagazine("Shock! Today's magazine since...")
}