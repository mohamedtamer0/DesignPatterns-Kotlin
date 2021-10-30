package proxy

class RealPicker:IPicker {
    override fun receiveMessage() {
        println("Receive text Message")
    }

    override fun takeCourier() {
        println("Take the Courier")
    }

    override fun signatureAcceptance() {
        println("Signature Acceptance")
    }
}