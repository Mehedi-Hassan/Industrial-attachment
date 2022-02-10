package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.userList.model.User
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(val userList: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val userName: MaterialTextView = view.findViewById(R.id.userName)
        val userDp: CircleImageView = view.findViewById(R.id.userDp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_user_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = userList[position]
        val fullName = currentData.first_name + " " + currentData.last_name
        holder.userName.text = currentData.first_name
        Picasso.get().load(currentData.avatar).into(holder.userDp)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}