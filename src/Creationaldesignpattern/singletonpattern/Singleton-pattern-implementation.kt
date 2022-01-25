package Creationaldesignpattern.singletonpattern


fun main() {
    val obj1 = Counter.MySingleton.instance
    val obj2 = Counter.MySingleton.instance
    obj1.addOne()
    obj2.addOne()
    println("Counter 1 : ${obj1.count}")
    println("Counter 2 : ${obj2.count}")

    obj1.addOne()
    obj2.addOne()
    println("Counter 1 : ${obj1.count}")
    println("Counter 2 : ${obj2.count}")
    println(obj1)
    println(obj2)


}

class Counter private constructor() {
    var count = 0
    fun addOne() {
        count++
    }

    object MySingleton {
        val instance = Counter()
    }
}



