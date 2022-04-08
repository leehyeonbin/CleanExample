package com.example.data.api

import com.example.data.model.DataLoveResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveCalculatorApi {

    @GET("getPercentage")
    suspend fun getPercentage(
        @Header("X-RapidAPI-Key") key : String,
        @Header("X-RapidAPI-Host") host : String,
        @Query("sname") sname : String,
        @Query("fname") fname : String
    ) : Response<DataLoveResponse>

}