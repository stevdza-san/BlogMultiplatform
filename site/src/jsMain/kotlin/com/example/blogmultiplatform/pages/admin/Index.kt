package com.example.blogmultiplatform.pages.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.blogmultiplatform.components.OverflowSidePanel
import com.example.blogmultiplatform.components.SidePanel
import com.example.blogmultiplatform.util.Constants.PAGE_WIDTH
import com.example.blogmultiplatform.util.isUserLoggedIn
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    isUserLoggedIn {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    var overflowMenuOpened by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .maxWidth(PAGE_WIDTH.px)
        ) {
            SidePanel(onMenuClick = {
                overflowMenuOpened = true
            })
            if(overflowMenuOpened) {
                OverflowSidePanel(onMenuClose = {
                    overflowMenuOpened = false
                })
            }
        }
    }
}