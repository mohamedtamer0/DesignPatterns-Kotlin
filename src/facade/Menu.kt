package facade

class Menu {
    private val italykitchen: Italykitchen
    private val frenchkitchen: Frenchkitchen

    init {
        italykitchen = ItalykitchenImpl()
        frenchkitchen = FrenchkitchenImpl()
    }

    fun bouillabaisse() {
        frenchkitchen.bouillabaisse()
    }

    fun cassoulet() {
        frenchkitchen.cassoulet()
    }

    fun pouleAuPot() {
        frenchkitchen.pouleAuPot()
    }

    fun lasagneWithTomatoAndCheese() {
        italykitchen.lasagneWithTomatoAndCheese()
    }

    fun prawnRisotto() {
        italykitchen.prawnRisotto()
    }

    fun creamCaramel() {
        italykitchen.creamCaramel()
    }


}
