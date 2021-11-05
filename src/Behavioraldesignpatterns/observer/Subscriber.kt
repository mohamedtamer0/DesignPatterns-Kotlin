package Behavioraldesignpatterns.observer

class Subscriber(magazine: Subject, subscriber: String) : Observer {
    private val subscriber: String
    override fun update(magazine: String) {
        println("Dear$subscriber: Your magazine has arrived, and today’s magazine is called《$magazine》")
    }

    init {
        magazine.registerObserver(this)
        this.subscriber = subscriber
    }
}