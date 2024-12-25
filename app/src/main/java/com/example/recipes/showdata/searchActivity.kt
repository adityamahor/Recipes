package com.example.recipes.showdata

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipes.Adapter.search_item_adapter
import com.example.recipes.Apis.ApiInterface
import com.example.recipes.Apis.retrofitobject
import com.example.recipes.R
import com.example.recipes.databinding.ActivitySearchBinding
import com.example.recipes.mvvm.recipesRepository
import com.example.recipes.mvvm.recipesViewmodel
import com.example.recipes.mvvm.recipesviewmodelFactory
import java.util.Locale

class searchActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySearchBinding
    private lateinit var myviewmodel : recipesViewmodel
    private lateinit var myAdapter : search_item_adapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.green)
        supportActionBar?.hide()

        binding.searchEditText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.searchEditText, InputMethodManager.SHOW_IMPLICIT)

        val recipeiinterface  = retrofitobject.INSTANCE().create(ApiInterface::class.java)
        val repo = recipesRepository(recipeiinterface)
        myviewmodel = ViewModelProvider(this,recipesviewmodelFactory(repo)).get(recipesViewmodel::class.java)

        myviewmodel.rcp.observe(this, Observer {
            myAdapter = search_item_adapter(this)
            binding.searchrecyclerview.layoutManager = LinearLayoutManager(this)
            binding.searchrecyclerview.adapter = myAdapter
            myviewmodel.rcp.observe(this) {list->
                list.recipes.let {
                    myAdapter.allrecipes.clear()
                    myAdapter.allrecipes.addAll(it)
                    myAdapter.notifyDataSetChanged()
                }
            }
            binding.progressBar.visibility = View.GONE

            myAdapter.setOnRecipeclicklistener(object : search_item_adapter.setOnRecipeclicklistener{
                override fun seteachRecipe(position: Int) {
                    val intent = Intent(this@searchActivity, show_data::class.java)
                    intent.putExtra("name",myAdapter.allrecipes[position].name)
                    intent.putExtra("image",myAdapter.allrecipes[position].image)
                    intent.putExtra("time",myAdapter.allrecipes[position].cookTimeMinutes.toString())
                    intent.putExtra("ingrediant",myAdapter.allrecipes[position].ingredients.toString())
                    intent.putExtra("steps",myAdapter.allrecipes[position].instructions.toString())
                    startActivity(intent)
                }
            })

        })

        binding.searchEditText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0!=null){
                    myAdapter.allrecipes.clear()
                    val searchtext = p0.toString()
                    myviewmodel.rcp.observe(this@searchActivity){ list->
                        list.recipes.forEach{
                            if(it.name.lowercase(Locale.getDefault()).contains(searchtext.lowercase(Locale.getDefault()))){
                                myAdapter.allrecipes.add(it)
                            }
                            myAdapter.notifyDataSetChanged()
                        }
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) { }
        })

        binding.backhome.setOnClickListener{
            finish()
        }

    }
}