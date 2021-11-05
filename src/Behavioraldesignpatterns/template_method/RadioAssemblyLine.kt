package Behavioraldesignpatterns.template_method

class RadioAssemblyLine : AssemblyLine() {

    override fun onProduceComponents() {
        println("Product Radio Components and Antennas")
    }

}