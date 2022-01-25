package Behavioraldesignpatterns.commandpatterns


fun main() = command()
fun command() {
    CommandProcessor()
        .addToQueue(OrderAddCommand(1L))
        .addToQueue(OrderAddCommand(2L))
        .addToQueue(OrderPayCommand(2L))
        .addToQueue(OrderPayCommand(1L))
        .processCommands()
}
