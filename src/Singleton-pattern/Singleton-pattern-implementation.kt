package `Singleton-pattern`


fun main() {
    val obj1: Counter = Counter.instance
    val obj2: Counter = Counter.instance
    obj1.addOne()
    obj2.addOne()
    println("Counter 1 : ${obj1.count}")
    println("Counter 2 : ${obj2.count}")

    obj1.addOne()
    obj2.addOne()
    println("Counter 1 : ${obj1.count}")
    println("Counter 2 : ${obj2.count}")


}

class Counter private constructor() {
    var count = 0
    fun addOne() {
        count++
    }

    companion object {
        val instance = Counter()
    }
}
