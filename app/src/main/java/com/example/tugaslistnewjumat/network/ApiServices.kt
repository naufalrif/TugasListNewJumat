package com.example.tugaslistnewjumat.network

import com.example.tugaslistnewjumat.model.GetAllNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsItem>>
}