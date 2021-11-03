package commandpatterns

class OrderAddCommand(private val id:Long) : OrderCommand {
    override fun execute() = println("Adding Order With id : $id")
}