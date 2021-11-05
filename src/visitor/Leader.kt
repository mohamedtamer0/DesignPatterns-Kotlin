package visitor

class Leader : Interviewer {
    override fun visit(student: Student) {
        println("Student  " + student.name + "'s gpa is " + student.gpa)
    }

    override fun visit(engineer: Engineer) {
        println(
            "Engineer  " + engineer.name + "'s number of projects is " + engineer.projectNumber
        )
    }
}