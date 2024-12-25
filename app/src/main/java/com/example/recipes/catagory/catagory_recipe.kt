package com.example.recipes.catagory

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipes.Adapter.category_adapter
import com.example.recipes.Apis.ApiInterface
import com.example.recipes.Apis.retrofitobject
import com.example.recipes.R
import com.example.recipes.databinding.ActivityCatagoryRecipeBinding
import com.example.recipes.model.Recipe
import com.example.recipes.mvvm.recipesRepository
import com.example.recipes.mvvm.recipesViewmodel
import com.example.recipes.mvvm.recipesviewmodelFactory
import com.example.recipes.showdata.show_data

class catagory_recipe : AppCompatActivity() {
    private lateinit var binding : ActivityCatagoryRecipeBinding
    private lateinit var myviewmodel : recipesViewmodel
    private lateinit var myadapter : category_adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatagoryRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.green)
        supportActionBar?.hide()

        getdata()

        binding.categoryname.text = intent.getStringExtra("name")

        binding.backhome.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                finish()
            }
        })

    }

    private fun getdata() {

        val Api = retrofitobject.INSTANCE().create(ApiInterface::class.java)
        val repo = recipesRepository(Api)
        myviewmodel = ViewModelProvider(this, recipesviewmodelFactory(repo)).get(recipesViewmodel::class.java)

        myviewmodel.rcp.observe(this, Observer{
            val list = it.recipes
            myadapter = category_adapter(list as ArrayList<Recipe>)
            binding.catagoryrecipeRecyclerview.layoutManager = LinearLayoutManager(this)
            binding.catagoryrecipeRecyclerview.adapter = myadapter
            binding.progressBar.visibility = View.GONE


            myadapter.setoncategoryclicklistener(object : category_adapter.clickOncategory{
                override fun oncategoryclick(position: Int) {
                    val intent = Intent(this@catagory_recipe, show_data::class.java)
                    intent.putExtra("name",list[position].name)
                    intent.putExtra("image",list[position].image)
                    intent.putExtra("time",list[position].cookTimeMinutes.toString())
                    intent.putExtra("ingrediant",list[position].ingredients.toString())
                    intent.putExtra("steps",list[position].instructions.toString())
                    startActivity(intent)
                }
            })

        })

    }

}