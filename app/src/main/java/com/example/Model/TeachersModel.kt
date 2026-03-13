package com.example.Model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class TeachersModel(
    val Address: String = "",
    val Biography: String = "",
    val Experience: Int = 0,
    val Id: Int = 0,
    val Location: String = "",
    val Mobile: String = "",
    val Name: String = "",
    val Rating: Double = 0.0,
    val Site: String = "",
    val Special: String = "",
    val Students: String = ""
) : Parcelable