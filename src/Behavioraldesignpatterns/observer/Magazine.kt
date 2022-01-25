package Behavioraldesignpatterns.observer

class Magazine : Subject {
    private val observerList: MutableList<Observer>

    init {
        observerList = ArrayList()
    }

    private var magazine: String? = null
    override fun registerObserver(observer: Observer) {
        observerList.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observerList.remove(observer)
    }

    override fun notifyObservers() {
        for (i in observerList.indices) {
            val observer = observerList[i]
            observer.update(magazine!!)
        }
    }

    fun setMagazine(magazine: String?) {
        this.magazine = magazine
        notifyObservers()
    }
}
