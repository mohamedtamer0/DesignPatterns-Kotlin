package strategy

fun main() {
    val context = Context()

    context.goToStrategy = GoToCairo()
    context.take()

    context.goToStrategy = GoToGona()
    context.take()


}