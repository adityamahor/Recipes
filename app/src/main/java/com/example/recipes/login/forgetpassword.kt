package com.example.recipes.login

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recipes.R
import com.example.recipes.databinding.ActivityForgetpasswordBinding
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

class forgetpassword : AppCompatActivity() {
    private lateinit var binding : ActivityForgetpasswordBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var progress : ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.green)

        // INSTANCE
        auth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
        progress.setCanceledOnTouchOutside(false)

        binding.getlink.setOnClickListener{
            val email = binding.forgetemail.text.toString()
            if(email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                progress.show()
                auth.sendPasswordResetEmail(email)
                    .addOnSuccessListener(object : OnSuccessListener<Void> {
                        override fun onSuccess(p0: Void?) {
                            progress.dismiss()
                            binding.forgetemail.text?.clear()
                            Toast.makeText(
                                this@forgetpassword,
                                "Check your email",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this@forgetpassword, signIn::class.java)
                            startActivity(intent)
                            finishAffinity()
                        }
                    })

                    .addOnFailureListener(object : OnFailureListener{
                        override fun onFailure(p0: Exception) {
                            progress.dismiss()
                            Toast.makeText(this@forgetpassword,p0.message,Toast.LENGTH_SHORT).show()
                        }
                    })
            }else{
                Toast.makeText(this@forgetpassword,"please enter valid email",Toast.LENGTH_SHORT).show()
            }
        }
    }
}