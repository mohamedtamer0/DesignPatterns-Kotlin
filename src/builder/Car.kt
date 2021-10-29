package builder

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


fun main() {
    val car1 = Car.build {
        brand = "Audi"
        color = "Blue"
        licensePlate = "C88888"
    }
    println(car1)

}