package com.example.recipes.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class recipesviewmodelFactory (private val Api : recipesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return recipesViewmodel(Api) as T
    }
}