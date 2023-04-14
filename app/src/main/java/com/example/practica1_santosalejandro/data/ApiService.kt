package com.example.practica1_santosalejandro.data

import com.example.practica1_santosalejandro.data.model.NumFactura
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("facturas")
    fun getFacturas() : Call<NumFactura>
}