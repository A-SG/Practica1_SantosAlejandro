package com.example.practica1_santosalejandro.ui.view

import DatePickerFragment
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica1_santosalejandro.databinding.ActivitySecondBinding
import java.time.Month

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageButtonSalir.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.fechaInicial.setOnClickListener(){
            mostrarDatepicker()
        }
    }

    private fun mostrarDatepicker() {
       val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day,month,year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day:Int, month: Int, year:Int){
        binding.fechaInicial.setText("$day/$month/$year")
    }
}