package com.example.recipes.showdata

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.recipes.R
import com.example.recipes.databinding.ActivityShowDataBinding
import com.google.gson.annotations.Until
import com.squareup.picasso.Picasso

class show_data : AppCompatActivity() {
    private lateinit var binding : ActivityShowDataBinding
    var imgcrop = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.green)
        supportActionBar?.hide()

        binding.fullscreen.setOnClickListener{
            if(imgcrop){
                binding.itemimage.scaleType = ImageView.ScaleType.FIT_CENTER
                binding.fullscreen.setColorFilter(R.color.white)
                imgcrop = false
            }else{
                binding.itemimage.scaleType = ImageView.ScaleType.CENTER_CROP
                binding.fullscreen.setColorFilter(R.color.black)
                imgcrop = true
            }
        }

        val image = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        val time = intent.getStringExtra("time")
        val ing = intent.getStringExtra("ingrediant")
        val stp = intent.getStringExtra("steps")

        for (i in ing.toString().split(", ")){
            binding.instruction.append("•  ${i}\n")
            binding.instruction.append("\n")
        }

        for (i in stp.toString().split(", ")){
            binding.stp.append("•  ${i}\n")
            binding.stp.append("\n")
        }

        Picasso.get().load(image).into(binding.itemimage)
        binding.recipetittle.text = name
        binding.recipetimetext.text = time+" min"

        binding.backhome.setOnClickListener{
            finish()
        }

        binding.ing.setOnClickListener{
            binding.ingredientdata.visibility = View.VISIBLE
            binding.stepdata.visibility = View.GONE
            binding.ing.setBackgroundResource(R.drawable.alternate_bg)
            binding.step.setBackgroundResource(R.drawable.btn_background)
            binding.ing.setTextColor(resources.getColor(R.color.black))
            binding.step.setTextColor(resources.getColor(R.color.white))

        }

        binding.step.setOnClickListener{
            binding.ingredientdata.visibility = View.GONE
            binding.stepdata.visibility = View.VISIBLE
            binding.ing.setBackgroundResource(R.drawable.btn_background)
            binding.step.setBackgroundResource(R.drawable.alternate_bg)
            binding.ing.setTextColor(resources.getColor(R.color.white))
            binding.step.setTextColor(resources.getColor(R.color.black))

        }
    }
}