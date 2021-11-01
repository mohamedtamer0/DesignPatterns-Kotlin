package template_method

abstract class AssemblyLine {

    protected open fun onProduceShell() {
        println("Produce Shell")
    }

    protected open fun onProduceComponents() {
        println("Produce some components")
    }

    protected open fun onAssemblyComponents() {
        println("Assembly Components")
    }

    protected open fun onTestProducts() {
        println("Test Products")
    }

    protected open fun onProductPacking() {
        println("Product Packing")
    }

    fun product() {
        println("+------Start Product------+")
        onProduceShell()
        onProduceComponents()
        onAssemblyComponents()
        onTestProducts()
        onProduceComponents()
        onProductPacking()
        println("+------Finish Product------+")
    }

}