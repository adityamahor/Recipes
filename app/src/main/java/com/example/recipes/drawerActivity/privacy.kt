package com.example.recipes.drawerActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recipes.MainActivity
import com.example.recipes.R
import com.example.recipes.databinding.ActivityPrivacyBinding

class privacy : AppCompatActivity() {
    private lateinit var binding : ActivityPrivacyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.green)
        supportActionBar?.hide()


        binding.acceptButton.setOnClickListener{
            startActivity(Intent(this@privacy, MainActivity::class.java))
            finishAffinity()
        }

    }
}