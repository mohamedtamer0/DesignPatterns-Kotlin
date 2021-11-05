package Behavioraldesignpatterns.visitor

interface Applicant {
    fun accept(visitor: Interviewer)
}
