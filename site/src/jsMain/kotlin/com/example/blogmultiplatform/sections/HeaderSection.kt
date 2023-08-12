package com.example.blogmultiplatform.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.blogmultiplatform.components.CategoryNavigationItems
import com.example.blogmultiplatform.components.SearchBar
import com.example.blogmultiplatform.models.Theme
import com.example.blogmultiplatform.util.Constants.HEADER_HEIGHT
import com.example.blogmultiplatform.util.Constants.PAGE_WIDTH
import com.example.blogmultiplatform.util.Res
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun HeaderSection(
    breakpoint: Breakpoint,
    onMenuOpen: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .backgroundColor(Theme.Secondary.rgb),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .backgroundColor(Theme.Secondary.rgb)
                .maxWidth(PAGE_WIDTH.px),
            contentAlignment = Alignment.TopCenter
        ) {
            Header(
                breakpoint = breakpoint,
                onMenuOpen = onMenuOpen
            )
        }
    }
}

@Composable
fun Header(
    breakpoint: Breakpoint,
    onMenuOpen: () -> Unit
) {
    var fullSearchBarOpened by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 80.percent else 90.percent)
            .height(HEADER_HEIGHT.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint <= Breakpoint.MD) {
            if(fullSearchBarOpened) {
                FaXmark(
                    modifier = Modifier
                        .margin(right = 24.px)
                        .color(Colors.White)
                        .cursor(Cursor.Pointer)
                        .onClick { fullSearchBarOpened = false },
                    size = IconSize.XL
                )
            }
            if(!fullSearchBarOpened) {
                FaBars(
                    modifier = Modifier
                        .margin(right = 24.px)
                        .color(Colors.White)
                        .cursor(Cursor.Pointer)
                        .onClick { onMenuOpen() },
                    size = IconSize.XL
                )
            }
        }
        if(!fullSearchBarOpened) {
            Image(
                modifier = Modifier
                    .margin(right = 50.px)
                    .width(if (breakpoint >= Breakpoint.SM) 100.px else 70.px)
                    .cursor(Cursor.Pointer)
                    .onClick { },
                src = Res.Image.logoHome,
                desc = "Logo Image"
            )
        }
        if (breakpoint >= Breakpoint.LG) {
            CategoryNavigationItems()
        }
        Spacer()
        SearchBar(
            breakpoint = breakpoint,
            fullWidth = fullSearchBarOpened,
            darkTheme = true,
            onEnterClick = {},
            onSearchIconClick = { fullSearchBarOpened = it }
        )
    }
}