package Behavioraldesignpatterns.iterator

class Book(private val name: String, private val ISBN: String, private val press: String) {

    override fun toString(): String {
        return "Book{" +
                "name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", press='" + press + '\'' +
                '}'
    }

}