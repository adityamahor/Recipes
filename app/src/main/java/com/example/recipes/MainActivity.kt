package com.example.recipes

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipes.Adapter.RecipesAdapter
import com.example.recipes.Apis.ApiInterface
import com.example.recipes.Apis.retrofitobject
import com.example.recipes.catagory.catagory_recipe
import com.example.recipes.databinding.ActivityMainBinding
import com.example.recipes.databinding.ShimmerlayoutBinding
import com.example.recipes.drawerActivity.aboutus
import com.example.recipes.drawerActivity.privacy
import com.example.recipes.login.signIn
import com.example.recipes.mvvm.recipesRepository
import com.example.recipes.mvvm.recipesViewmodel
import com.example.recipes.mvvm.recipesviewmodelFactory
import com.example.recipes.showdata.searchActivity
import com.example.recipes.showdata.show_data
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var MyAdapter : RecipesAdapter
    private lateinit var auth : FirebaseAuth
    private lateinit var myViewmodel  : recipesViewmodel
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.green)
        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        val recipeiinterface  = retrofitobject.INSTANCE().create(ApiInterface::class.java)
        val repo = recipesRepository(recipeiinterface)
        myViewmodel = ViewModelProvider(this,recipesviewmodelFactory(repo)).get(recipesViewmodel::class.java)

        myViewmodel.rcp.observe(this, Observer{
            val list = it.recipes
            MyAdapter = RecipesAdapter(list)
            binding.popularRecipesRecyclerview.layoutManager = LinearLayoutManager(this)
            binding.popularRecipesRecyclerview.adapter = MyAdapter
            binding.progressBar.visibility = View.GONE

            MyAdapter.setOnRecipeclicklistener(object : RecipesAdapter.setOnRecipeclicklistener{
                override fun seteachRecipe(position: Int) {
                    val intent = Intent(this@MainActivity, show_data::class.java)
                    intent.putExtra("name",list[position].name)
                    intent.putExtra("image",list[position].image)
                    intent.putExtra("time",list[position].cookTimeMinutes.toString())
                    intent.putExtra("ingrediant",list[position].ingredients.toString())
                    intent.putExtra("steps",list[position].instructions.toString())
                    startActivity(intent)
                }
            })

        })

        optionmenubutton()

        drawermenubutton()

        binding.searchRecipe.setOnClickListener{
            startActivity(Intent(this@MainActivity, searchActivity::class.java))
        }

        categoryclick()

    }

    private fun categoryclick() {
        binding.salad.setOnClickListener{
            val intent = Intent(this@MainActivity, catagory_recipe::class.java)
            intent.putExtra("name",binding.saladtittle.text)
            startActivity(intent)
        }
        binding.pizza.setOnClickListener{
            val intent = Intent(this@MainActivity, catagory_recipe::class.java)
            intent.putExtra("name",binding.pizzatittle.text)
            startActivity(intent)
        }
        binding.dinner.setOnClickListener{
            val intent = Intent(this@MainActivity, catagory_recipe::class.java)
            intent.putExtra("name",binding.dinnertittle.text)
            startActivity(intent)
        }
        binding.sweet.setOnClickListener{
            val intent = Intent(this@MainActivity, catagory_recipe::class.java)
            intent.putExtra("name",binding.sweettittle.text)
            startActivity(intent)
        }
        binding.drink.setOnClickListener{
            val intent = Intent(this@MainActivity, catagory_recipe::class.java)
            intent.putExtra("name",binding.drinktittle.text)
            startActivity(intent)
        }
        binding.snack.setOnClickListener{
            val intent = Intent(this@MainActivity, catagory_recipe::class.java)
            intent.putExtra("name",binding.snacktittle.text)
            startActivity(intent)
        }
    }

    private fun drawermenubutton() {
        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.logout -> {
                  val dialog  = AlertDialog.Builder(this)
                    dialog.setTitle("Are you sure")
                    dialog.setMessage("Do you want to logout ?")
                    dialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                        auth.signOut()
                        val intent = Intent(this@MainActivity, signIn::class.java)
                        startActivity(intent)
                        finishAffinity()
                    })
                    dialog.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                    })
                    dialog.show()

                }
                R.id.privacy -> {
                   val intent = Intent(this@MainActivity, privacy::class.java)
                    startActivity(intent)
                }
                R.id.aboutus -> {
                    val intent = Intent(this@MainActivity, aboutus::class.java)
                    startActivity(intent)
                }
                R.id.share->{
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.example.recipes")
                    startActivity(Intent.createChooser(intent, "Share via"))
                }
                R.id.rating->{
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://play.google.com/store/apps/details?id=com.example.recipes")
                    startActivity(intent)
                }
            }
            binding.main.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }

    private fun optionmenubutton() {
        binding.mytoolbar.setNavigationOnClickListener {
            if (binding.main.isDrawerOpen(GravityCompat.START)) {
                binding.main.closeDrawer(GravityCompat.START)
            } else {
                binding.main.openDrawer(GravityCompat.START)
            }
        }
    }

    private fun showShimmer() {
        val shimmer = ShimmerlayoutBinding.inflate(layoutInflater)
        setContentView(shimmer.root)
        shimmer.shimmerLayout.startShimmer()
        shimmer.shimmerLayout.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            shimmer.shimmerLayout.stopShimmer()
            shimmer.shimmerLayout.visibility = View.GONE
            binding.maincontent.visibility = View.VISIBLE
        }, 3000)
    }


}