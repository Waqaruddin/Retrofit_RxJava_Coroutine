package com.example.rxjavawithretrofit.model

data class UsersResponse(
        val count: Int,
        val data: ArrayList<Users>,
        val error: Boolean
)

data class Users(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val landlordEmail: String,
    val name: String,
    val password: String,
    val type: String
)