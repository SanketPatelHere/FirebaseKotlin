package com.example.basic

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Animals(val name:String, val leg:Int) : Serializable {}

