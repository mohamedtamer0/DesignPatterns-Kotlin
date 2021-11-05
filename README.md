# DesignPatterns-Kotlin
## Design Patterns
- In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem in software design. A design pattern isn't a finished design that can be transformed directly into code. It is a description or template for how to solve a problem that can be used in many different situations.
## Creational design patterns
- Singleton
- Creationaldesignpattern.prototype
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
- Behavioraldesignpatterns.commandpatterns
- Interpreter
- Iterator
- Behavioraldesignpatterns.mediator
- Memento
- Null Object
- Observer
- State
- Strategy
- Template method
- Visitor



## Creational design patterns

>In software engineering, creational design patterns are design patterns that deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. The basic form of object creation could result in design problems or added complexity to the design. Creational design patterns solve this problem by somehow controlling this object creation.
>


- Singleton

The singleton pattern ensures that only one object of a particular class is ever created. All further references to objects of the singleton class refer to the same underlying instance. There are very few applications, do not overuse this pattern!

## UML :

<img src="https://user-images.githubusercontent.com/51374446/139603038-66b99d0b-9c34-4f6f-ae14-5277fd2a814b.jpg" style="width:300px;height:300px"/>


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
## Creationaldesignpattern.prototype
The Prototype pattern delegates the cloning process to the actual objects that are being cloned. The patte![Creationaldesignpattern.prototype]
rn declares a common interface for all objects that support cloning. This interface lets you clone an object without coupling your code to the class of that object. Usually, such an interface contains just a single clone method.

The implementation of the clone method is very similar in all classes. The method creates an object of the current class and carries over all of the field values of the old object into the new one. You can even copy private fields because most programming languages let objects access private fields of other objects that belong to the same class.

An object that supports cloning is called a Creationaldesignpattern.prototype. When your objects have dozens of fields and hundreds of possible configurations, cloning them might serve as an alternative to subclassing.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/Creationaldesignpattern.prototype.png"/>

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
The Creationaldesignpattern.builder pattern is used to create complex objects with constituent parts that must be created in the same order or using a specific algorithm. An external class controls the construction algorithm.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/Creationaldesignpattern.builder.png"/>

### Example:


```kotlin
data class Car
constructor(var color: String, var licensePlate: String, var brand: String) {

    private constructor(Creationaldesignpattern.builder: Builder) : this(
        Creationaldesignpattern.builder.color,
        Creationaldesignpattern.builder.licensePlate,
        Creationaldesignpattern.builder.brand
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


##
## Factory Method
The Creationaldesignpattern.factory pattern is used to replace class constructors, abstracting the process of object generation so that the type of the object instantiated can be determined at run-time.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/factory_method.png"/>

### Example:

```kotlin
interface Cake {
    fun prepareMaterials();
    fun banking();
}

```

```kotlin
class MangoCake : Cake {
    override fun prepareMaterials() {
        println("prepare Mango Cream")
    }

    override fun banking() {
        println("Baking ten minutes")
    }
}

```

```kotlin
abstract class Factory {
    abstract fun <T : Cake> createProduct(clz:Class<T>): T?
}

```

```kotlin
class CakeFactory : Factory() {
    override fun <T : Cake> createProduct(clz: Class<T>): T? {
        var cake: Cake? = null
        try {
            cake = Class.forName(clz.name).getDeclaredConstructor().newInstance() as Cake
        }catch (e : Exception) {
            e.printStackTrace()
        }
        return cake as T?
    }
}

```



### Usage :

```kotlin
    val Creationaldesignpattern.factory : Factory = CakeFactory()
    val mangoCake = Creationaldesignpattern.factory.createProduct(MangoCake::class.java)?.apply {
        prepareMaterials()
        banking()
    }
```

### Outpu:

```code
prepare Mango Cream
Baking ten minutes
```




##
## Abstract Factory
The abstract Creationaldesignpattern.factory pattern is used to provide a client with a set of related or dependant objects. The "family" of objects created by the Creationaldesignpattern.factory are determined at run-time.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/abstract_factory.png"/>

### Example:

```kotlin
abstract class CakeFactory {
    abstract fun cream():CakeCream
    abstract fun style():CakeStyle
}

```

```kotlin
abstract class CakeCream {
    abstract fun cream()
}

```

```kotlin
abstract class CakeStyle {
    abstract fun style()
}
```

```kotlin
class HeartStyle:CakeStyle() {
    override fun style() {
        println("Heart Style")
    }
}

```

```kotlin
class MangoCream:CakeCream() {
    override fun cream() {
        println("Mango Cream")
    }
}
```

```kotlin
class MangoHeartCake : CakeFactory(){
    override fun cream(): CakeCream {
        return MangoCream()
    }

    override fun style(): CakeStyle {
        return HeartStyle()
    }
}

```




### Usage :

```kotlin
    val mangoHeartCake: CakeFactory = MangoHeartCake()
    mangoHeartCake.cream().cream()
    mangoHeartCake.style().style()

    println("=================")

    val mangoSquareCake: CakeFactory = MangoSquareCake()
    mangoSquareCake.cream().cream()
    mangoSquareCake.style().style()
```

### Outpu:

```code
Mango Cream
Heart Style
=================
Mango Cream
Square Style
```


##
## Structural Patterns : 

>In software engineering, structural design patterns are design patterns that ease the design by identifying a simple way to realize relationships between entities.
>

## Protection Proxy
The Structuraldesignpatterns.proxy pattern is used to provide a surrogate or placeholder object, which references an underlying object. Protection Structuraldesignpatterns.proxy is restricting access.


## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/Structuraldesignpatterns.proxy.png"/>

### Example:

```kotlin
interface IPicker {
    fun receiveMessage()
    fun takeCourier()
    fun signatureAcceptance()
}

```

```kotlin
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

```

```kotlin
class ProxyPicker(private val picker: IPicker) : IPicker by picker

```



### Usage :

```kotlin
    val picker:IPicker  = RealPicker()
    val proxyPicker = ProxyPicker(picker)
    proxyPicker.receiveMessage()
    proxyPicker.takeCourier()
    proxyPicker.signatureAcceptance()
```

### Outpu:

```code
Receive text Message
Take the Courier
Signature Acceptance
```



## Decorator
The Structuraldesignpatterns.decorator pattern is used to extend or alter the functionality of objects at run-time by wrapping them in an object of a Structuraldesignpatterns.decorator class. This provides a flexible alternative to using inheritance to modify behaviour.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/Structuraldesignpatterns.decorator.png"/>

### Example:

```kotlin
interface Cake {
    fun make()
}

```

```kotlin
class CakeEmbryo : Cake {
    override fun make() {
        println("Baking Cake")
    }
}

```

```kotlin
open class DecoratorCake constructor(val cake : Cake): Cake by cake

```

```kotlin
class FruitCake constructor(cake:Cake) :DecoratorCake(cake) {

    override fun make() {
        addSomeFruit()
        super.make()
    }

    private fun addSomeFruit() {
        println("Add Some Fruit")
    }

}

```



### Usage :

```kotlin
    val cake: Cake = CakeEmbryo()
    cake.make()

    println("--------Decorate Fruit Cake--------")
    val fruitCake: DecoratorCake = FruitCake(cake)
    fruitCake.make()
```

### Outpu:

```code
Baking Cake
--------Decorate Fruit Cake--------
Add Some fruit
Baking Cake
```


## Adapter
The Structuraldesignpatterns.adapter pattern is used to provide a link between two otherwise incompatible types by wrapping the "adaptee" with a class that supports the interface required by the client.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/class_adapter.png"/>

### Example:

```kotlin
interface VoltFive {
    fun provideVoltFive():Int
}

```

```kotlin
class Volt220 {

    fun provideVolt220(): Int {
        return 220
    }
}

```

```kotlin
class VoltAdapter(private val volt220: Volt220) : VoltFive {

    override fun provideVoltFive(): Int {
        val volt = volt220.provideVolt220()
        return 5
    }

    fun provideVolt220(): Int {
        return volt220.provideVolt220()
    }
}

```


### Usage :

```kotlin
    val volt220 = Volt220()
    val Structuraldesignpatterns.adapter = VoltAdapter(volt220)

    val volt = Structuraldesignpatterns.adapter.provideVoltFive()
    println("After Structuraldesignpatterns.adapter, the volt is : $volt")
```

### Outpu:

```code
After Structuraldesignpatterns.adapter, the volt is :5
```




## Facade
The Structuraldesignpatterns.facade pattern is used to define a simplified interface to a more complex subsystem.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/Structuraldesignpatterns.facade.png"/>

### Example:

```kotlin
interface Italykitchen {

    fun lasagneWithTomatoAndCheese()
    fun prawnRisotto()
    fun creamCaramel()
}

```

```kotlin
class ItalykitchenImpl : Italykitchen {
    override fun lasagneWithTomatoAndCheese() {
        println("Lasagne With Tomato And Cheese")
    }

    override fun prawnRisotto() {
        println("Prawn Risotto")
    }

    override fun creamCaramel() {
        println("Cream Caramel")
    }
}

```

```kotlin
interface Frenchkitchen {

    fun bouillabaisse()
    fun cassoulet()
    fun pouleAuPot()

}

```

```kotlin
class FrenchkitchenImpl : Frenchkitchen {
    override fun bouillabaisse() {
        println("Bouillabaisse")
    }

    override fun cassoulet() {
        println("Cassoulet")
    }

    override fun pouleAuPot() {
        println("PouleAuPot")
    }
}

```

```kotlin
class Menu {
    private val italykitchen: Italykitchen
    private val frenchkitchen: Frenchkitchen

    init {
        italykitchen = ItalykitchenImpl()
        frenchkitchen = FrenchkitchenImpl()
    }

    fun bouillabaisse() {
        frenchkitchen.bouillabaisse()
    }

    fun cassoulet() {
        frenchkitchen.cassoulet()
    }

    fun pouleAuPot() {
        frenchkitchen.pouleAuPot()
    }

    fun lasagneWithTomatoAndCheese() {
        italykitchen.lasagneWithTomatoAndCheese()
    }

    fun prawnRisotto() {
        italykitchen.prawnRisotto()
    }

    fun creamCaramel() {
        italykitchen.creamCaramel()
    }

}

```


### Usage :

```kotlin
    val menu = Menu()
    println("Customer order")
    menu.lasagneWithTomatoAndCheese()
    menu.creamCaramel()

    println("===========New Order==========")
    println("Customer two orders")
    menu.bouillabaisse()
    menu.prawnRisotto()
```

### Outpu:

```code
Customer order
Lasagne With Tomato And Cheese
Cream Caramel
===========New Order==========
Customer two orders
Bouillabaisse
Prawn Risotto
```








