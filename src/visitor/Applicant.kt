package visitor

interface Applicant {
    fun accept(visitor: Interviewer)
}
