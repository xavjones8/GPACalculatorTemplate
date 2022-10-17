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

        //TODO: Retrieve data from intents

        lblProjectedGPA.text = "Projected GPA: $gpa"
        lblCurrentGPA.text = "Current GPA: $gpa"
        val class_names = mutableListOf<ClassRowDetails>()

        //Populates list view with number of classes
        for(i in 1..numberOfClasses) {
            class_names.add(ClassRowDetails("Class $i", null, null))
        }

        //TODO: Recycler views are much more efficient than list views. Try changing this implementation to use a recycler view.
        val listView: ListView = findViewById(R.id.semester_list)
        val listAdapter = ClassListAdapter(this, class_names)
        listView.adapter = listAdapter


        btnCalculate.setOnClickListener() {

        }

        //TODO: Implement this feature!
        btnClearForm.setOnClickListener {
            Toast.makeText(this, "Complete this method!", Toast.LENGTH_SHORT).show()
        }

    }
}