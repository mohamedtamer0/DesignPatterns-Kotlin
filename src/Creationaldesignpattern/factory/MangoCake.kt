package Creationaldesignpattern.factory

class MangoCake : Cake {
    override fun prepareMaterials() {
        println("prepare Mango Cream")
    }

    override fun banking() {
        println("Baking ten minutes")
    }
}