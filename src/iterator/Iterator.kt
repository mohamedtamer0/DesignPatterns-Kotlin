package iterator

interface Iterator<T> {
     operator fun hasNext(): Boolean
     operator fun next(): T
}