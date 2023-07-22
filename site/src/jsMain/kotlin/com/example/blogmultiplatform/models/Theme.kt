package com.example.blogmultiplatform.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.rgba

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(
        hex = "#00A2FF",
        rgb = rgb(r = 0, g = 162, b = 255)
    ),
    Secondary(
        hex = "#001019",
        rgb = rgb(r = 0, g = 16, b = 25)
    ),
    LightGray(
        hex = "#FAFAFA",
        rgb = rgb(r = 250, g = 250, b = 250)
    ),
    HalfWhite(
        hex = "#FFFFFF",
        rgb = rgba(r = 255, g = 255, b = 255, a = 0.5)
    ),
    HalfBlack(
        hex = "#000000",
        rgb = rgba(r = 0, g = 0, b = 0, a = 0.5)
    ),
    White(
        hex = "#FFFFFF",
        rgb = rgb(r = 255, g = 255, b = 255)
    ),
    Green(
        hex = "#00FF94",
        rgb = rgb(r = 0, g = 255, b = 148)
    ),
    Yellow(
        hex = "#FFEC45",
        rgb = rgb(r = 255, g = 236, b = 69)
    ),
    Red(
        hex = "#FF6359",
        rgb = rgb(r = 255, g = 99, b = 89)
    ),
    Purple(
        hex = "#8B6DFF",
        rgb = rgb(r = 139, g = 109, b = 255)
    ),
}