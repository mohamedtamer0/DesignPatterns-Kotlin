package Behavioraldesignpatterns.mediator

fun main() {
    val mediator = ChatMediator()
    val john = ChatUser(mediator, "Tamer")

    mediator
        .addUser(ChatUser(mediator, "Mohab"))
        .addUser(ChatUser(mediator, "Mohand"))
        .addUser(ChatUser(mediator, "Habiba"))
        .addUser(john)
    john.send("Hi everyone!")

}