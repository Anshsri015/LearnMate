package com.example.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.Model.CategoryModel
import com.example.learnmate.R
import com.example.learnmate.databinding.ViewholdercategoryBinding

class CategoryAdapter(val items: MutableList<CategoryModel>):
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

        private lateinit var context: Context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
       context=parent.context
        val binding= ViewholdercategoryBinding.inflate(LayoutInflater.from(context),parent,false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int
    ) {
      val item=items[position]
        holder.binding.title.text=item.Name



        val imageRes = when(item.Name) {

            "Mathematics" -> R.drawable.mathematics
            "Science" -> R.drawable.science
            "English" -> R.drawable.english
            "Computer Science" -> R.drawable.computer_science
            "Physics" -> R.drawable.physics

            else ->R.drawable.placeholder
        }

        holder.binding.subjectPic.setImageResource(imageRes)



    }

    override fun getItemCount(): Int =items.size


    inner class CategoryViewHolder(val binding: ViewholdercategoryBinding): RecyclerView.ViewHolder(binding.root){
    }
}

