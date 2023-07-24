package com.example.blogmultiplatform.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
actual data class Post(
    @SerialName("_id")
    actual val id: String,
    actual val author: String,
    actual val date: Long,
    actual val title: String,
    actual val subtitle: String,
    actual val thumbnail: String,
    actual val content: String,
    actual val category: Category,
    actual val popular: Boolean = false,
    actual val main: Boolean = false,
    actual val sponsored: Boolean = false
)
