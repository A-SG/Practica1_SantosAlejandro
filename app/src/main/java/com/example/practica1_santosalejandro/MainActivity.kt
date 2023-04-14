package com.example.practica1_santosalejandro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
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


        binding.rvFacturas.layoutManager = LinearLayoutManager(this)
        mostrarFacturas()
    }


    private fun mostrarFacturas(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://viewnextandroid.mocklab.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val retroData = retrofit.getFacturas()

        retroData.enqueue(object : Callback<List<Factura>> {
            override fun onResponse(call: Call<List<Factura>>,response: Response<List<Factura>>) {

                var data = response.body()!!
                adapter = FacturasAdapter(data)
                binding.rvFacturas.adapter = adapter

                Log.d("ASG", data.toString())
            }
            override fun onFailure(call: Call<List<Factura>>, t: Throwable) {

            }

        })
    }
}