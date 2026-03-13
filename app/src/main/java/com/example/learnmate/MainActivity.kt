package com.example.learnmate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Activity.TopTeacherActivity
import com.example.Adapter.CategoryAdapter
import com.example.Adapter.TeacherAdapter
import com.example.Model.CategoryModel
import com.example.Model.TeachersModel
import com.example.ViewModel.MainViewModel
import com.example.learnmate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategory()
        initTeacher()

    }

    private fun initTeacher() {
        binding.progressbarTeacher.visibility = View.VISIBLE
        viewModel.teacher.observe(
            this,
            {
                binding.TopTeacher.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                  binding.TopTeacher.adapter= TeacherAdapter(it.toMutableList())
                binding.progressbarTeacher.visibility = View.GONE
            }
        )
        viewModel.loadTeachers()

        binding.seelist.setOnClickListener {
            startActivity(Intent(this@MainActivity, TopTeacherActivity::class.java))
        }

    }

    private fun initCategory() {
        binding.progressbarCategory.visibility = View.VISIBLE
        viewModel.category.observe(
            this,
            {
                binding.viewCategory.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                binding.viewCategory.adapter= CategoryAdapter(it.toMutableList())
                binding.progressbarCategory.visibility = View.GONE
            }
        )
        viewModel.loadCategory()
    }
}