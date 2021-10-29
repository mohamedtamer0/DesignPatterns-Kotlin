package factory

abstract class Factory {
    abstract fun <T : Cake> createProduct(clz:Class<T>): T?
}