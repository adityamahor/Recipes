package com.example.recipes.Apis

import com.example.recipes.model.mydata
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/recipes")

    suspend fun getRecipes(): Response<mydata>

}