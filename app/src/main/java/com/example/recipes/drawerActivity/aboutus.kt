package com.example.recipes.drawerActivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recipes.R
import com.example.recipes.databinding.ActivityAboutusBinding

class aboutus : AppCompatActivity() {
    private lateinit var binding : ActivityAboutusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.green)
        supportActionBar?.hide()

    }
}