package adapter

class VoltAdapter(private val volt220: Volt220) : VoltFive {

    override fun provideVoltFive(): Int {
        val volt = volt220.provideVolt220()
        return 5
    }

    fun provideVolt220(): Int {
        return volt220.provideVolt220()
    }
}
