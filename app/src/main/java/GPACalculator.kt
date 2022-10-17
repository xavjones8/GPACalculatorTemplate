public class GPACalculator(private val currentGPA: Double, private val currentDegreeCredits: Int, private val semesterGPA: SemesterDetails) {
    private val currentCreditPoints: Double = currentGPA * currentDegreeCredits

    fun getProjectedGPA(): Double{
        return (semesterGPA.getTotalPoints() + currentCreditPoints) / (semesterGPA.getTotalCredits() + currentDegreeCredits)
    }

    override fun toString(): String {
        return String.format("%.2f", getProjectedGPA())
    }
}