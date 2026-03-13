package com.example.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Adapter.TeacherAdapter
import com.example.Adapter.TopTeacherSeeAdapter
import com.example.ViewModel.MainViewModel
import com.example.learnmate.R
import com.example.learnmate.databinding.ActivityTopTeacherBinding

class TopTeacherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopTeacherBinding
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityTopTeacherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initTeachersee()
        binding.backbtnsee.setOnClickListener { finish() }

    }
    private fun initTeachersee() {
        binding.progressbarsee.visibility = View.VISIBLE
        viewModel.teacher.observe(
            this,
            {
                binding.recyletopSee.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.recyletopSee.adapter= TopTeacherSeeAdapter(it.toMutableList())
                binding.progressbarsee.visibility = View.GONE
            }
        )
        viewModel.loadTeachers()

    }
}