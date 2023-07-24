package com.example.blogmultiplatform.data

import com.example.blogmultiplatform.models.Post
import com.example.blogmultiplatform.models.User

interface MongoRepository {
    suspend fun addPost(post: Post): Boolean
    suspend fun checkUserExistence(user: User): User?
    suspend fun checkUserId(id: String): Boolean
}