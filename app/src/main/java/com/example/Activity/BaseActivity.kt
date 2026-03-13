package com.example.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       window.setFlags(
           WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
           WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
       )


    }
}