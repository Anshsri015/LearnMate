package com.example.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learnmate.R
import com.example.learnmate.databinding.ActivityForgetPasswordBinding

class ForgetPassword : AppCompatActivity() {
    private lateinit var binding: ActivityForgetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
   binding=ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}