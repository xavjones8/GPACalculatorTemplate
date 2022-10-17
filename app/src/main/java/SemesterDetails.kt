class SemesterDetails(private val classes: MutableList<ClassDetails>) {

    fun getTotalCredits(): Int {
        var hours: Int = 0
        classes.forEach { hours += it.creditHours  }
        return hours
    }

    fun getTotalPoints(): Double {
        var points: Double = 0.0
        classes.forEach { points += it.gradePoints  }
        return points
    }

    fun getSemesterGPA(): Double {
        return getTotalPoints() / getTotalCredits()
    }
}