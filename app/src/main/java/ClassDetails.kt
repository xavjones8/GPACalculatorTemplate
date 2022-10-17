data class ClassDetails(val creditHours: Int, val grade: String) {

    val gradePoints = creditHours * getCreditPoints()

    private fun getCreditPoints(): Double{
        when (grade) {
            "A+" -> return 4.333
            "A" -> return 4.0
            "A-" -> return 3.666
            "B+" -> return 3.333
            "B" -> return 3.0
            "B-" -> return 2.666
            "C+" -> return 2.333
            "C" -> return 2.0
            "C-" -> return 1.666
            "D+" -> return 1.333
            "D" -> return 1.0
            "D-" -> return 0.666
            "F" -> return 0.0
            else -> throw IllegalArgumentException("Invalid Grade Type")
        }
    }
}