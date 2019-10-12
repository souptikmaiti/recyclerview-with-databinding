package com.example.recyclerviewwithdatabinding.adapter

import android.view.View
import com.example.recyclerviewwithdatabinding.data.User

interface ItemListener {
    fun onItemClick(view: View, user:User)
}