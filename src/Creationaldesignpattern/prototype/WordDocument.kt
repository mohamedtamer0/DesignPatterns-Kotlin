package Creationaldesignpattern.prototype

import java.util.ArrayList
class WordDocument constructor(
    var text: String = "",
    private var images: ArrayList<String> = ArrayList<String>())
    : Cloneable {

    init { println("-----Init-----") }
    fun addImage(image: String) = images.add(image)
    fun showDocument() {
        println("-----Start-----")
        println("Text: $text")
        println("Images List: ")
        images.map {
            println("Image name: $it")
        }
        println("-----End-----") }

    fun cloneTo(): WordDocument? {
        try {
            val copy: WordDocument = super.clone() as WordDocument
            copy.text = this.text
            copy.images = this.images.clone() as ArrayList<String>
            return copy
        } catch (e: CloneNotSupportedException) { e.printStackTrace() }
        return null
    }
}


fun main() {
    val originDoc: WordDocument = WordDocument().apply {
        text = "This is a document"
        addImage("Image 1")
        addImage("Image 2")
        addImage("Image 3")
        showDocument() }

    val copyDoc: WordDocument? = originDoc.cloneTo()?.apply {
        showDocument()
        text = "This is a copy document"
        addImage("A new image")
        showDocument() }
    copyDoc!!.showDocument()

}