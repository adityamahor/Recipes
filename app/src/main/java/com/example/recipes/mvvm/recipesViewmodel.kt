package com.example.recipes.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.model.mydata
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class recipesViewmodel (private val Api : recipesRepository) : ViewModel() {

    init {
        viewModelScope.launch{
            Api.getRecipes()
        }
    }

    val rcp : LiveData<mydata>
        get() = Api.recipes

}