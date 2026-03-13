package com.example.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.example.learnmate.MainActivity
import com.example.learnmate.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            joinNow.setOnClickListener {
                startActivity(Intent(this@IntroActivity, SignIn::class.java))
                finish()
            }
        }

    }
}