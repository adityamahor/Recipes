package com.example.recipes.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.recipes.MainActivity
import com.example.recipes.R
import com.example.recipes.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Runnable

class splash : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.green)

        auth = FirebaseAuth.getInstance()

        if(auth.currentUser != null){
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                val intent = Intent(this@splash, MainActivity::class.java)
                startActivity(intent)
                finish()
            },3300)
        }else{
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                val intent = Intent(this@splash, signIn::class.java)
                startActivity(intent)
                finish()
            },3300)
        }

    }
}