package iterator

import kotlin.collections.Iterator


class Literature : BookIterable {
    val literature: Array<Book?>

    operator fun iterator(): Iterator {
        return LiteratureIterator(literature)
    }

    init {
        literature = arrayOfNulls(4)
        literature[0] = Book("Three Kingdoms", "9787532237357", "Shanghai People's Fine Arts Publishing House")
        literature[1] = Book("Journey to the West", "9787805200552", "Yuelu Publishing House")
        literature[2] = Book("Water Margin", "9787020015016", "People's Literature Publishing House")
        literature[3] = Book("Dream of Red Mansions", "9787020002207", "People's Literature Publishing House")
    }
}
