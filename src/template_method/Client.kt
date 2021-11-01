package template_method


fun main() {

    var assemblyLine: AssemblyLine = RadioAssemblyLine()
    assemblyLine.product()

    println()

    assemblyLine = ComputerAssemblyLine()
    assemblyLine.product()
}