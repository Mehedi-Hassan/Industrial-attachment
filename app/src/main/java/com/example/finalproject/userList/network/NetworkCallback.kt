package com.example.finalproject.userList.network

import com.example.finalproject.userList.model.User

interface NetworkCallback {
    fun getList(userList: List<User>)
}