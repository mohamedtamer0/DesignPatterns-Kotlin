package Creationaldesignpattern.abstract_factory

class MangoSquareCake:CakeFactory() {
    override fun cream(): CakeCream {
        return MangoCream()
    }

    override fun style(): CakeStyle {
        return SquareStyle()
    }
}