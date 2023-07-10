package com.example.blogmultiplatform.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(
        hex = "#00A2FF",
        rgb = rgb(r = 0, g = 162, b = 255)
    ),
    LightGray(
        hex = "#FAFAFA",
        rgb = rgb(r = 250, g = 250, b = 250)
    )
}