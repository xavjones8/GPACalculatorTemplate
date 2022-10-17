package com.example.gpacalculator_master

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

public class StartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        val txtGPA: EditText = findViewById(R.id.txtCurrentGPA)
        val txtCurrentHours: EditText = findViewById(R.id.txtNumberOfDegreeHours)
        val txtNumberOfClasses: EditText = findViewById(R.id.txtNumberOfClasses)
        val btnNextScreen: Button = findViewById(R.id.btnNext)

        var gpa: Double = 0.0
        var currentHours: Int = 0
        var numberOfClasses: Int = 0
        btnNextScreen.setOnClickListener {
            gpa = txtGPA.text.toString().toDouble()
            currentHours = txtCurrentHours.text.toString().toInt()
            numberOfClasses = txtNumberOfClasses.text.toString().toInt()
            val intent = Intent(this, SemesterActivity::class.java)
            intent.putExtra("GPA", gpa)
            intent.putExtra("Hours", currentHours)
            intent.putExtra("Classes", numberOfClasses)

            this.startActivity(intent)
        }
    }


}