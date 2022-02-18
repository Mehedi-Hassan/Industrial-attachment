package com.example.finalproject.userList.model

data class PaginatedData(
        val page: Int,
        val per_page: Int,
        val total: Int,
        val total_page: Int,
        val data: List<User>
)
