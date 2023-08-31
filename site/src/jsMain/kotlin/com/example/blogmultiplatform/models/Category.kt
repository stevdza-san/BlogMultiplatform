package com.example.blogmultiplatform.models

import kotlinx.serialization.Serializable
import com.example.blogmultiplatform.CategoryCommon

@Serializable
enum class Category(override val color: String): CategoryCommon {
    Technology(color = Theme.Green.hex),
    Programming(color = Theme.Yellow.hex),
    Design(color = Theme.Purple.hex)
}