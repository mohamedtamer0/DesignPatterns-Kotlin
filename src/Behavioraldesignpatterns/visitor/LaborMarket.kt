package Behavioraldesignpatterns.visitor

class LaborMarket {
    var applicants: MutableList<Applicant> = ArrayList()
    fun showApplicants(visitor: Interviewer?) {
        for (applicant in applicants) {
            applicant.accept(visitor!!)
        }
    }

    init {
        applicants.add(Student("Tamer", 3.2, "Computer Science"))
        applicants.add(Student("Mohamed", 3.4, "Network Engineer"))
        applicants.add(Student("Habiba", 3.4, "Computer Science"))
        applicants.add(Engineer("Ahmed", 4, 15))
        applicants.add(Engineer("Mohand", 3, 10))
        applicants.add(Engineer("Mohab", 6, 20))
    }
}
