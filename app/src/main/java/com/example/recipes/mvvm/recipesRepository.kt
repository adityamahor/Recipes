package com.example.recipes.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recipes.Apis.ApiInterface
import com.example.recipes.model.mydata

class recipesRepository(private val Apiinterface : ApiInterface) {

    private val recipesLiveData = MutableLiveData<mydata>()

    val recipes : LiveData<mydata>
    get() = recipesLiveData

    suspend fun getRecipes(){
        val result = Apiinterface.getRecipes()
       if(result.body()!=null){
           recipesLiveData.postValue(result.body())
       }
    }

}