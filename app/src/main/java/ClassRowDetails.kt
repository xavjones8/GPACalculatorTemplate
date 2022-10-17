class ClassRowDetails(val title: String, var hours: String?, var grade: String?) {

    var isComplete = false
        get() = hasGrade() && hasHours()

    fun hasHours(): Boolean {
        return hours != null
    }

    fun hasGrade(): Boolean {
        return grade != null
    }

//    fun addHours(newHours: String?) {
//        hours = newHours
//    }



}