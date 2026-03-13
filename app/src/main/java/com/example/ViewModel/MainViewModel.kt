package com.example.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.Model.CategoryModel
import com.example.Model.TeachersModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.MutableData
import com.google.firebase.database.ValueEventListener
import java.sql.Ref

class MainViewModel() : ViewModel() {

    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _category = MutableLiveData<List<CategoryModel>>()
    private val _teacher = MutableLiveData<List<TeachersModel>>()


    val category: LiveData<List<CategoryModel>> = _category
    val teacher: LiveData<List<TeachersModel>> = _teacher


    fun loadCategory() {
        val ref = firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<CategoryModel>()
                for (childSnapshot in snapshot.children) {
                    val categoryItem = childSnapshot.getValue(CategoryModel::class.java)
                    categoryItem?.let {
                        list.add(it)
                    }

                    _category.value = list
                }
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun loadTeachers(){
        val ref=firebaseDatabase.getReference("Teachers")
        ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               val lists=mutableListOf<TeachersModel>()
               for(childSnapshot in snapshot.children){
                   val TeacherItem=childSnapshot.getValue(TeachersModel::class.java)
                   TeacherItem?.let{
                       lists.add(it)

                   }
                   _teacher.value=lists
               }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
            })
        }
    }
