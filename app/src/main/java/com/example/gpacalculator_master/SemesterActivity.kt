package com.example.gpacalculator_master

import ClassDetails
import ClassListAdapter
import ClassRowDetails
import GPACalculator
import SemesterDetails
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.gpacalculator_master.R.*

class SemesterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_semester)


        val btnCalculate = findViewById(R.id.btnCalculateGPA) as Button
        val btnClearForm = findViewById(R.id.btnClearForm) as Button
        val lblProjectedGPA = findViewById(R.id.lblProjectedGPA) as TextView
        val lblCurrentGPA = findViewById(R.id.lblCurrentTotalGPA) as TextView

        val gpa: Double = intent?.extras?.getDouble("GPA")!!
        val currentHours: Int = intent?.extras?.getInt("Hours")!!
        val numberOfClasses: Int = intent?.extras?.getInt("Classes")!!

        lblProjectedGPA.text = "Projected GPA: $gpa"
        lblCurrentGPA.text = "Current GPA: $gpa"
        val class_names = mutableListOf<ClassRowDetails>()

        //Populates list view with number of classes
        for(i in 1..numberOfClasses) {
            class_names.add(ClassRowDetails("Class $i", null, null))
        }

        val listView: ListView = findViewById(R.id.semester_list)
        val listAdapter = ClassListAdapter(this, class_names)
        listView.adapter = listAdapter


        btnCalculate.setOnClickListener() {
            val classes = mutableListOf<ClassDetails>()

            for(i in 0..listAdapter.count - 1) {
                val row = listAdapter.getItem(i)
                if(row == null || !row.isComplete) continue

                try {
                    classes.add(ClassDetails(row.hours?.toInt()!!, row.grade!!))
                } catch( e: Exception) {
                    val alertDialogBuilder = AlertDialog.Builder(this)
                    alertDialogBuilder.setMessage("Each class' credit hours amount must be a number\nEach class grade must be in the form of [Letter][+/-/_] Ex. A+, C, D-")
                    alertDialogBuilder.setTitle("Error")

//                    Toast.makeText(this,
//                        "Each class' credit hours amount must be a number\nEach class grade must be in the form of [Letter][+/-/_] Ex. A+, C, D-",
//                        Toast.LENGTH_LONG).show()
                    alertDialogBuilder.show()
                    continue
                }

                val semester = SemesterDetails(classes)
                val gpaCalculator = GPACalculator(gpa, currentHours, semester)
                lblProjectedGPA.text = "Projected GPA ${gpaCalculator.toString()}"

            }
        }

    }
}