package template_method

class ComputerAssemblyLine : AssemblyLine() {

    override fun onProduceShell() {
        println("Product Aluminum housing and Liquid Crystal Display")
    }

    override fun onProduceComponents() {
        println("Product Components and keyboard")
    }

    override fun onProductPacking() {
        println("Pack and Mark the Apple trademark")
    }

}