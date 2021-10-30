package decorator

class FruitCake constructor(cake:Cake) :DecoratorCake(cake) {

    override fun make() {
        addSomeFruit()
        super.make()
    }

    private fun addSomeFruit() {
        println("Add Some Fruit")
    }

}