package com.example.practica1_santosalejandro

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("facturas")
    fun getFacturas() : Call<List<Factura>>
}