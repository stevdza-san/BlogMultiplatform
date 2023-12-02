package com.example.blogmultiplatform.styles

import com.example.shared.JsTheme
import com.example.blogmultiplatform.util.Id
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.ms

val NavigationItemStyle by ComponentStyle {
    cssRule(" > #${Id.svgParent} > #${Id.vectorIcon}") {
        Modifier
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
            .styleModifier {
                property("stroke", JsTheme.White.hex)
            }
    }
    cssRule(":hover > #${Id.svgParent} > #${Id.vectorIcon}") {
        Modifier
            .styleModifier {
            property("stroke", JsTheme.Primary.hex)
        }
    }
    cssRule(" > #${Id.navigationText}") {
        Modifier
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
            .color(JsTheme.White.rgb)
    }
    cssRule(":hover > #${Id.navigationText}") {
        Modifier.color(JsTheme.Primary.rgb)
    }
}