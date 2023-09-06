package com.example.blogmultiplatform.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

val PostPreviewStyle by ComponentStyle {
    base {
        Modifier
            .scale(100.percent)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 100.ms))
    }
    hover {
        Modifier
            .boxShadow(
                offsetY = 0.px,
                offsetX = 0.px,
                blurRadius = 8.px,
                spreadRadius = 6.px,
                color = rgba(0, 0, 0, 0.06)
            )
            .scale(102.percent)
    }
}

val MainPostPreviewStyle by ComponentStyle {
    base {
        Modifier
            .scale(100.percent)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 100.ms))
    }
    hover {
        Modifier
            .boxShadow(
                offsetY = 0.px,
                offsetX = 0.px,
                blurRadius = 8.px,
                spreadRadius = 6.px,
                color = rgba(0, 162, 255, 0.06)
            )
            .scale(102.percent)
    }
}