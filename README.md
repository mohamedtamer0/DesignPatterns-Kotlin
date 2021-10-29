# DesignPatterns-Kotlin
## Design Patterns
- In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem in software design. A design pattern isn't a finished design that can be transformed directly into code. It is a description or template for how to solve a problem that can be used in many different situations.
## Creational design patterns
- Singleton
- prototype
- Object Pool
- Factory Method
- Builder
- Abstract Factory

## Structural design patterns
- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Private Class Data
- Proxy

## Behavioral design patterns
- Chain of responsibility
- Command
- Interpreter
- Iterator
- Mediator
- Memento
- Null Object
- Observer
- State
- Strategy
- Template method
- Visitor



## Creational design patterns

### Singleton

The singleton pattern ensures that only one object of a particular class is ever created. All further references to objects of the singleton class refer to the same underlying instance. There are very few applications, do not overuse this pattern!

### Example:

```Kotlin
class Counter private constructor() {
    var count = 0
    fun addOne() {
        count++
    }

    companion object {
        val instance = Counter()
    }
}
```

### Usage :

```Kotlin
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
```

### Output :

```code
Counter 1 : 2
Counter 2 : 2
Counter 1 : 4
Counter 2 : 4
```
