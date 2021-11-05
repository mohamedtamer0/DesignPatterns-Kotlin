package Structuraldesignpatterns.proxy

fun main() {
    val picker:IPicker  = RealPicker()
    val proxyPicker = ProxyPicker(picker)
    proxyPicker.receiveMessage()
    proxyPicker.takeCourier()
    proxyPicker.signatureAcceptance()

}