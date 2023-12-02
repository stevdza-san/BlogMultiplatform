package com.example.shared

import kotlinx.serialization.Serializable

@Serializable
actual enum class Category(override val color: String): CategoryColor {
    Technology(color = JvmTheme.Green.hex),
    Programming(color = JvmTheme.Yellow.hex),
    Design(color = JvmTheme.Purple.hex)
}

enum class JvmTheme(val hex: String) {
    Purple(hex = "#8B6DFF"),
    Green(hex = "#00FF94"),
    Yellow(hex = "#FFEC45")
}