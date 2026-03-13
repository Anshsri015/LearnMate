package com.example.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.Activity.DetailActivity
import com.example.Model.TeachersModel
import com.example.learnmate.databinding.ViewholderTopteacherseeallBinding
import com.example.learnmate.databinding.ViewholderteacherBinding

class TopTeacherSeeAdapter(val items:MutableList<TeachersModel>): RecyclerView.Adapter<TopTeacherSeeAdapter.ViewHolder>() {
  private var context: Context?=null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
     context=parent.context
        val binding= ViewholderTopteacherseeallBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.binding.namesee.text=items[position].Name
        holder.binding.specialsee.text=items[position].Special
        holder.binding.ratingtext.text=items[position].Rating.toString()
        holder.binding.ratingbar.rating=items[position].Rating.toFloat()

        holder.binding.buttonSee.setOnClickListener {
            val intent= Intent(context, DetailActivity::class.java)
            intent.putExtra("Object",items[position])
            context?.startActivity(intent)
        }

    }

    override fun getItemCount(): Int =items.size

    class ViewHolder(val binding: ViewholderTopteacherseeallBinding): RecyclerView.ViewHolder(binding.root){

    }
}