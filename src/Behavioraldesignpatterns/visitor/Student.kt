package Behavioraldesignpatterns.visitor

class Student(var name: String, var gpa: Double, var major: String) : Applicant {

    override fun accept(visitor: Interviewer) {
        visitor.visit(this)
    }

}
