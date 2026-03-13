package com.example.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.Activity.DetailActivity
import com.example.Model.TeachersModel
import com.example.learnmate.databinding.ViewholderteacherBinding

class TeacherAdapter(val items:MutableList<TeachersModel>): RecyclerView.Adapter<TeacherAdapter.ViewHolder>() {
  private var context: Context?=null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
     context=parent.context
        val binding= ViewholderteacherBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.binding.teacherName.text=items[position].Name
        holder.binding.teacherSpecial.text=items[position].Special
        holder.binding.teacherStar.text=items[position].Rating.toString()
        holder.binding.teacherExp.text=items[position].Experience.toString()+"Year"

        holder.itemView.setOnClickListener {
            val intent= Intent(context, DetailActivity::class.java)
            intent.putExtra("Object",items[position])
            context?.startActivity(intent)
        }

    }

    override fun getItemCount(): Int =items.size

    class ViewHolder(val binding: ViewholderteacherBinding): RecyclerView.ViewHolder(binding.root){

    }
}