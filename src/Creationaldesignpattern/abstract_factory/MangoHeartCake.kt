package Creationaldesignpattern.abstract_factory

class MangoHeartCake : CakeFactory(){
    override fun cream(): CakeCream {
        return MangoCream()
    }

    override fun style(): CakeStyle {
        return HeartStyle()
    }
}