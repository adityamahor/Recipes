package com.example.recipes.model

data class mydata(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
)