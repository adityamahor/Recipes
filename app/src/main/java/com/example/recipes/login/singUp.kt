package com.example.recipes.login

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recipes.MainActivity
import com.example.recipes.R
import com.example.recipes.databinding.ActivitySingUpBinding
import com.google.firebase.auth.FirebaseAuth

class singUp : AppCompatActivity() {
    private lateinit var binding : ActivitySingUpBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var progress : ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

      supportActionBar?.hide()
        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.green)

        // instance
        auth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("please wait")
        progress.setMessage("creating your account...")
        progress.setCanceledOnTouchOutside(false)

        binding.signupbtn.setOnClickListener {

            val name = binding.signupusername.text.toString()
            val email = binding.signUpemail.text.toString()
            val password = binding.signuppassword.text.toString()

            if(binding.check.isChecked) {

                if(name.isEmpty() && name.length<5){
                    Toast.makeText(this@singUp, "please enter valid name", Toast.LENGTH_SHORT).show()
                }else if(email.isEmpty()){
                    Toast.makeText(this@singUp, "please enter your email", Toast.LENGTH_SHORT).show()
                }else if(password.isEmpty()){
                    Toast.makeText(this@singUp, "please enter your password", Toast.LENGTH_SHORT).show()
                }else if(password.length < 6){
                    Toast.makeText(this@singUp, "please make some strong password", Toast.LENGTH_SHORT).show()
                }else {
                    if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                            if (it.isSuccessful) {
                                progress.show()
                                val intent = Intent(this@singUp, signIn::class.java)
                                startActivity(intent)
                                finishAffinity()
                            } else {
                                progress.dismiss()
                                Toast.makeText(this@singUp, "please try again", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        Toast.makeText(this@singUp, "please enter valid email", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this@singUp, "please check the terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }

    }
}