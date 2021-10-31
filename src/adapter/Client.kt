package adapter


fun main() {

    val volt220 = Volt220()
    val adapter = VoltAdapter(volt220)

    val volt = adapter.provideVoltFive()
    println("After adapter, the volt is : $volt")
}