package Behavioraldesignpatterns.strategy

class Context {
    var goToStrategy:Strategy? = null

    fun take() {
        goToStrategy?.transportation()
    }

}