package Creationaldesignpattern.abstract_factory

fun main() {
    val mangoHeartCake: CakeFactory = MangoHeartCake()
    mangoHeartCake.cream().cream()
    mangoHeartCake.style().style()

    println("=================")

    val mangoSquareCake: CakeFactory = MangoSquareCake()
    mangoSquareCake.cream().cream()
    mangoSquareCake.style().style()


}