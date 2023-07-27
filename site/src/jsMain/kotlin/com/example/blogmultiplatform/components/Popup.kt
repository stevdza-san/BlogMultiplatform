package com.example.blogmultiplatform.components

import androidx.compose.runtime.Composable
import com.example.blogmultiplatform.models.Theme
import com.example.blogmultiplatform.util.Constants.FONT_FAMILY
import com.example.blogmultiplatform.util.Id
import com.example.blogmultiplatform.util.noBorder
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.document
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Input
import org.w3c.dom.HTMLInputElement

@Composable
fun MessagePopup(
    message: String,
    onDialogDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(100.vw)
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(19),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .backgroundColor(Theme.HalfBlack.rgb)
                .onClick { onDialogDismiss() }
        )
        Box(
            modifier = Modifier
                .padding(all = 24.px)
                .backgroundColor(Colors.White)
                .borderRadius(r = 4.px)
        ) {
            SpanText(
                modifier = Modifier
                    .fillMaxWidth()
                    .textAlign(TextAlign.Center)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(16.px),
                text = message
            )
        }
    }
}

@Composable
fun LinkPopup(
    onDialogDismiss: () -> Unit,
    onLinkAdded: (String, String) -> Unit
) {
    Box(
        modifier = Modifier
            .width(100.vw)
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(19),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .backgroundColor(Theme.HalfBlack.rgb)
                .onClick { onDialogDismiss() }
        )
        Column(
            modifier = Modifier
                .width(500.px)
                .padding(all = 24.px)
                .backgroundColor(Colors.White)
                .borderRadius(r = 4.px)
        ) {
            Input(
                type = InputType.Text,
                attrs = Modifier
                    .id(Id.linkHrefInput)
                    .fillMaxWidth()
                    .height(54.px)
                    .padding(left = 20.px)
                    .margin(bottom = 12.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .noBorder()
                    .borderRadius(r = 4.px)
                    .backgroundColor(Theme.LightGray.rgb)
                    .toAttrs {
                        attr("placeholder", "Href")
                    }
            )
            Input(
                type = InputType.Text,
                attrs = Modifier
                    .id(Id.linkTitleInput)
                    .fillMaxWidth()
                    .height(54.px)
                    .padding(left = 20.px)
                    .margin(bottom = 20.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .noBorder()
                    .borderRadius(r = 4.px)
                    .backgroundColor(Theme.LightGray.rgb)
                    .toAttrs {
                        attr("placeholder", "Title")
                    }
            )
            Button(
                attrs = Modifier
                    .onClick {
                        val href =
                            (document.getElementById(Id.linkHrefInput) as HTMLInputElement).value
                        val title =
                            (document.getElementById(Id.linkTitleInput) as HTMLInputElement).value
                        onLinkAdded(href, title)
                        onDialogDismiss()
                    }
                    .fillMaxWidth()
                    .height(54.px)
                    .borderRadius(r = 4.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .noBorder()
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .toAttrs()
            ) {
                SpanText(text = "Add")
            }
        }
    }
}