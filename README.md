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

- Singleton

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
##
## prototype
The Prototype pattern delegates the cloning process to the actual objects that are being cloned. The pattern declares a common interface for all objects that support cloning. This interface lets you clone an object without coupling your code to the class of that object. Usually, such an interface contains just a single clone method.

The implementation of the clone method is very similar in all classes. The method creates an object of the current class and carries over all of the field values of the old object into the new one. You can even copy private fields because most programming languages let objects access private fields of other objects that belong to the same class.

An object that supports cloning is called a prototype. When your objects have dozens of fields and hundreds of possible configurations, cloning them might serve as an alternative to subclassing.

### Example:


```Kotlin
import java.util.ArrayList

class WordDocument 
constructor(var text: String = "", private var images: ArrayList<String> = ArrayList<String>()) : Cloneable {


    init {
        println("-----Init-----")
    }

    fun addImage(image: String) = images.add(image)

    fun showDocument() {
        println("-----Start-----")
        println("Text: $text")
        println("Images List: ")
        images.map {
            println("Image name: $it")
        }
        println("-----End-----")
    }

    fun cloneTo(): WordDocument? {
        try {
            val copy: WordDocument = super.clone() as WordDocument
            copy.text = this.text
            copy.images = this.images.clone() as ArrayList<String>
            return copy
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return null
    }

}
```

### Usage :
```Kotlin
fun main() {
    val originDoc: WordDocument = WordDocument().apply {
        text = "This is a document"
        addImage("Image 1")
        addImage("Image 2")
        addImage("Image 3")
        showDocument()


    }

    val copyDoc: WordDocument? = originDoc.cloneTo()?.apply {
        showDocument()
        text = "This is a copy document"
        addImage("A new image")
        showDocument()
    }
    copyDoc!!.showDocument()
}
```
## Output:

```code
-----Init-----
-----Start-----
Text: This is a document
Images List: 
Image name: Image 1
Image name: Image 2
Image name: Image 3
-----End-----
-----Start-----
Text: This is a document
Images List: 
Image name: Image 1
Image name: Image 2
Image name: Image 3
-----End-----
-----Start-----
Text: This is a copy document
Images List: 
Image name: Image 1
Image name: Image 2
Image name: Image 3
Image name: A new image
-----End-----
-----Start-----
Text: This is a copy document
Images List: 
Image name: Image 1
Image name: Image 2
Image name: Image 3
Image name: A new image
-----End-----

```


##
## Builder
The builder pattern is used to create complex objects with constituent parts that must be created in the same order or using a specific algorithm. An external class controls the construction algorithm.

### Example:


```kotlin
data class Car
constructor(var color: String, var licensePlate: String, var brand: String) {

    private constructor(builder: Builder) : this(
        builder.color,
        builder.licensePlate,
        builder.brand
    )

    class Builder {
        lateinit var color: String
        lateinit var licensePlate: String
        lateinit var brand: String

        fun color(init: Builder.() -> String) = apply { color = init() }
        fun licensePlate(init: Builder.() -> String) = apply { licensePlate = init() }
        fun brand(init: Builder.() -> String) = apply { brand = init() }
    }

    companion object {
        fun build(init: Builder.() -> Unit) = Car(Builder().apply(init))
    }

}
```

## Usage:

```kotlin
    val car1 = Car.build {
        brand = "Audi"
        color = "Blue"
        licensePlate = "C88888"
    }
    println(car1)
```


## Output:

```code
Car(color=Blue, licensePlate=C88888, brand=Audi)
```



