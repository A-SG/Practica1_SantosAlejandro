package com.example.practica1_santosalejandro.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.practica1_santosalejandro.data.ApiService
import com.example.practica1_santosalejandro.data.adapter.FacturasAdapter
import com.example.practica1_santosalejandro.data.model.NumFactura
import com.example.practica1_santosalejandro.databinding.ActivityMainBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : FacturasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButtonFiltro.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        adapter = FacturasAdapter(emptyList())
        binding.rvFacturas.adapter = adapter
        mostrarFacturas()

    }


    private fun mostrarFacturas(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://viewnextandroid.wiremockapi.cloud/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val retroData = retrofit.getFacturas()

        retroData.enqueue(object : Callback<NumFactura> {
            override fun onResponse(
                call: Call<NumFactura>,
                response: Response<NumFactura>) {

                var data = response.body()!!
                Log.d("ASG", data.facturas.toString())

                adapter.facturas = data.facturas
                adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<NumFactura>, t: Throwable) {
            }

        })
    }

    fun filtrarFacturasActivity(view : View){

        }
    }
