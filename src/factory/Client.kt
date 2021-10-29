package factory

fun main() {
    val factory : Factory = CakeFactory()
    val mangoCake = factory.createProduct(MangoCake::class.java)?.apply {
        prepareMaterials()
        banking()
    }
}