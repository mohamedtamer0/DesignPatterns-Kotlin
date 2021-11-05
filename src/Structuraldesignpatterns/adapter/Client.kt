package Structuraldesignpatterns.adapter


fun main() {

    val volt220 = Volt220()
    val adapter = VoltAdapter(volt220)

    val volt = adapter.provideVoltFive()
    println("After Structuraldesignpatterns.adapter, the volt is : $volt")
}