package com.example.Activity

import android.content.Intent
import androidx.credentials.GetCredentialRequest

import android.os.Bundle
import android.widget.Toast
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException
import androidx.lifecycle.lifecycleScope
import com.example.learnmate.MainActivity
import com.example.learnmate.R
import com.example.learnmate.databinding.ActivitySignInBinding
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class SignIn : BaseActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var credentialManager: CredentialManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        credentialManager = CredentialManager.create(this)


        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))

        }
        binding.tvForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgetPassword::class.java))
        }

        binding.btnSignInWithGoogle.setOnClickListener {
            signInWithGoogle()
        }
    }


    fun signInWithGoogle() {
        val googleIdOption= GetGoogleIdOption.Builder()
            .setServerClientId(getString(R.string.default_web_client_id))
            .setFilterByAuthorizedAccounts(false)
            .build()

        val request= GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        lifecycleScope.launch {
            try {


                val result = credentialManager.getCredential(
                    request = request,
                    context = this@SignIn
                )
                handleSignIn(result)
            }
            catch (e: GetCredentialException){
                Toast.makeText(this@SignIn,"SignIn Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun handleSignIn(result: GetCredentialResponse){
        val credential = result.credential

        if (credential is CustomCredential &&
            credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
        ) {

            val googleTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)

            firebaseAuthWithGoogle(googleTokenCredential.idToken)
        }

    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val firebaseCredential =
            GoogleAuthProvider.getCredential(idToken, null)

        auth.signInWithCredential(firebaseCredential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()

                    val user = auth.currentUser
                } else {
                    Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }
}