package decorator

fun main() {

    val cake: Cake = CakeEmbryo()
    cake.make()

    println("--------Decorate Fruit Cake--------")
    val fruitCake: DecoratorCake = FruitCake(cake)
    fruitCake.make()

}