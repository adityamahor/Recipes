package com.example.recipes.login

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recipes.MainActivity
import com.example.recipes.R
import com.example.recipes.databinding.ActivitySignInBinding
import com.example.recipes.model.usermodel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.FirebaseDatabase

class signIn : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var progress : ProgressDialog
    private lateinit var databse : FirebaseDatabase
    private lateinit var gsc : GoogleSignInClient
    private lateinit var gso : GoogleSignInOptions

    val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.green)

        // instance
        databse = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("please wait")
        progress.setMessage("Logging in your account...")
        progress.setCanceledOnTouchOutside(false)

        binding.registration.setOnClickListener{
            val intent = Intent(this@signIn, singUp::class.java)
            startActivity(intent)
        }

        binding.forgetpassword.setOnClickListener{
            val intent = Intent(this@signIn, forgetpassword::class.java)
            startActivity(intent)
        }

        binding.signInbtn.setOnClickListener {

            val email = binding.signInemail.text.toString()
            val password = binding.signInpassword.text.toString()

            if(binding.check.isChecked) {

                if(email.isEmpty()){
                    Toast.makeText(this@signIn, "please enter your email", Toast.LENGTH_SHORT).show()
                }else if(password.isEmpty()){
                    Toast.makeText(this@signIn, "please enter your password", Toast.LENGTH_SHORT).show()
                }else if(password.length < 6){
                    Toast.makeText(this@signIn, "please enter valid password", Toast.LENGTH_SHORT).show()
                }else {
                    if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                            if (it.isSuccessful) {
                                progress.show()
                                val intent = Intent(this@signIn, MainActivity::class.java)
                                startActivity(intent)
                                finishAffinity()
                            } else {
                                progress.dismiss()
                                Toast.makeText(this@signIn, "please try again", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        Toast.makeText(this@signIn, "please enter valid email", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this@signIn, "please check the terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }


        gso = GoogleSignInOptions.Builder()
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        gsc = GoogleSignIn.getClient(this, gso)

        binding.logingoogle.setOnClickListener{

            login()

        }
    }

    private fun login() {
        val siginintent = gsc.signInIntent
        startActivityForResult(siginintent,RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try{
                val account = task.getResult(ApiException::class.java)
                firbaseauthcredantial(account.idToken)
            }catch (E : Exception){
                Toast.makeText(this@signIn, "please try again", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun firbaseauthcredantial(idtoken: String?) {
        val credantial = GoogleAuthProvider.getCredential(idtoken,null)
        auth.signInWithCredential(credantial).addOnCompleteListener {
            if(it.isSuccessful){

                val user = auth.currentUser

                val USERMODEL = usermodel(
                    user?.uid,
                    user?.displayName,
                    user?.email,
                    user?.photoUrl.toString()
                )

                databse.getReference().child("allusers").child(user?.uid!!).setValue(USERMODEL)


                val intent = Intent(this@signIn, MainActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }else{
                Toast.makeText(this@signIn, "please try again", Toast.LENGTH_SHORT).show()
            }
        }

    }

}