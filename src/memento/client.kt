package memento

fun main() {
    val originator = Originator("initial state")
    val careTaker = CareTaker()
    careTaker.saveState(originator.createMemento())

    originator.state = "State #1"
    originator.state = "State #2"
    careTaker.saveState(originator.createMemento())

    originator.state = "State #3"
    println("Current State: " + originator.state)


    originator.restore(careTaker.restore(1))
    println("Second saved state: " + originator.state)


    originator.restore(careTaker.restore(0))
    println("First saved state: " + originator.state)
}