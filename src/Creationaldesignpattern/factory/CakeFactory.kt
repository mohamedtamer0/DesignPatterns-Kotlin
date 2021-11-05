package Creationaldesignpattern.factory

class CakeFactory : Factory() {
    override fun <T : Cake> createProduct(clz: Class<T>): T? {
        var cake: Cake? = null
        try {
            cake = Class.forName(clz.name).getDeclaredConstructor().newInstance() as Cake
        }catch (e : Exception) {
            e.printStackTrace()
        }
        return cake as T?
    }
}