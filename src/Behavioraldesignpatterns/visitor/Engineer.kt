package Behavioraldesignpatterns.visitor

class Engineer(var name: String, var workExperience: Int, var projectNumber: Int) : Applicant {

    override fun accept(visitor: Interviewer) {
        visitor.visit(this)
    }

}