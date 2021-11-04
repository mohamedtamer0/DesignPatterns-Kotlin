package observer

class Bookstore(magazine: Subject) : Observer {
    override fun update(magazine: String) {
        println("Our shop updates the magazine today：《$magazine》")
    }

    init {
        magazine.registerObserver(this)
    }
}
