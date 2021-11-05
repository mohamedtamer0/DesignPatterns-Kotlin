package Structuraldesignpatterns.facade

class FrenchkitchenImpl : Frenchkitchen {
    override fun bouillabaisse() {
        println("Bouillabaisse")
    }

    override fun cassoulet() {
        println("Cassoulet")
    }

    override fun pouleAuPot() {
        println("PouleAuPot")
    }
}