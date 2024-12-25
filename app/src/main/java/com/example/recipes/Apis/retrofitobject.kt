package com.example.recipes.Apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitobject {

    val base_url = "https://dummyjson.com"

      fun INSTANCE() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}