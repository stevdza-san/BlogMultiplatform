package com.example.blogmultiplatform.models

expect class User {
    val id: String
    val username: String
    val password: String
}

expect class UserWithoutPassword {
    val id: String
    val username: String
}