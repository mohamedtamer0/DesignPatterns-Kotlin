package chain_of_responsibility

fun main() {
    val tutor:Tutor = Tutor()
    val secretary:Secretary = Secretary()
    val dean = Dean()
    val principal = Principal()

    tutor.successor = secretary
    secretary.successor = dean
    dean.successor = principal
    principal.successor = null

    tutor.handleRequest(12000)
    secretary.handleRequest(100)
}