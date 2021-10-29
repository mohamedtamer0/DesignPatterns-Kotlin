package Prototype

class Employees : Cloneable {
    var empList: MutableList<String>

    internal constructor() {
        empList = ArrayList()
    }

    internal constructor(emp: MutableList<String>) {
        empList = emp
    }

    fun loaddata() {
        empList.add("Ahmed")
        empList.add("Sayed")
        empList.add("Mohamed")
        empList.add("Abdallah")
    }

    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Any {
        val temp: MutableList<String> = ArrayList()
        for (s in empList) {
            temp.add(s)
        }
        return Employees(temp)
    }

}


fun main() {
    val employes = Employees()
    employes.loaddata()
    val emps1 = employes.clone() as Employees
    val emps2 = employes.clone() as Employees
    val list = emps1.empList
    list.add("Ebrahim")
    emps2.empList.remove("Mohamed")
    println("First list: " + employes.empList)
    println("emps1 list: $list")
    println("emps2 list: " + emps2.empList)
}
