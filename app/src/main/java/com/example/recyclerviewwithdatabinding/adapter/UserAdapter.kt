package com.example.recyclerviewwithdatabinding.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithdatabinding.R
import com.example.recyclerviewwithdatabinding.data.User
import com.example.recyclerviewwithdatabinding.databinding.UserItemBinding
import com.example.recyclerviewwithdatabinding.ui.HomeFragment


class UserAdapter(var listUsers:List<User>, var fragment: HomeFragment) :RecyclerView.Adapter<UserAdapter.UserHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        var userBinding:UserItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.user_item,parent,false)

        return UserHolder(userBinding)
    }

    override fun getItemCount(): Int = listUsers.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        var user: User = listUsers[position]
        holder.userItemBinding.userModel = user
    }

    inner class UserHolder(var userItemBinding: UserItemBinding) : RecyclerView.ViewHolder(userItemBinding.root){
        init {
            userItemBinding.listener = fragment
        }
    }
}