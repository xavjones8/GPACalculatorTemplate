package com.example.gpacalculator_master

import ClassDetails
import GPACalculator
import SemesterDetails
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GPACalculatorTest {
    @Test
    fun classDetailsTest() {

        val class1 = ClassDetails(4, "A+")
        assertEquals(17.332, class1.gradePoints, 0.0)

        val exception = assertThrows(IllegalArgumentException::class.java) {
            val class2 = ClassDetails(4, "Z")
        }
        assertEquals("Invalid Grade Type", exception.message)

    }

    @Test
    fun semesterDetailsTest() {
        val class1 = ClassDetails(4, "A+")
        val class2 = ClassDetails(2, "C")

        val semester = SemesterDetails(arrayOf(class1, class2))
        assertEquals(6, semester.getTotalCredits())
        assertEquals(21.332, semester.getTotalPoints(), 0.0)
        assertEquals(3.55, semester.getSemesterGPA(), 0.01)
    }

    @Test
    fun gpaCalculatorTest() {
        val class1 = ClassDetails(4, "A+")
        val class2 = ClassDetails(2, "C")

        val semester = SemesterDetails(arrayOf(class1, class2))

        val gpa = GPACalculator(4.0, 31, semester)
        assertEquals(3.92, gpa.getProjectedGPA(), 0.01)

    }
}