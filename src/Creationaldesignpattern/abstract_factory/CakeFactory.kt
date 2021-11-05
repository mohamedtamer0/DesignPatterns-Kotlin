package Creationaldesignpattern.abstract_factory

abstract class CakeFactory {
    abstract fun cream():CakeCream
    abstract fun style():CakeStyle
}