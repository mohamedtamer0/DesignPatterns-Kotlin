package Structuraldesignpatterns.facade

class ItalykitchenImpl : Italykitchen {
    override fun lasagneWithTomatoAndCheese() {
        println("Lasagne With Tomato And Cheese")
    }

    override fun prawnRisotto() {
        println("Prawn Risotto")
    }

    override fun creamCaramel() {
        println("Cream Caramel")
    }
}