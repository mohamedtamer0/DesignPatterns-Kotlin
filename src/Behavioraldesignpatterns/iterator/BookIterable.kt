package Behavioraldesignpatterns.iterator

import kotlin.collections.Iterator

interface BookIterable<T> {
      operator fun iterator(): Iterator<T>?
}