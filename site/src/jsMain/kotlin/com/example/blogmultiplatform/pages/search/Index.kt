package com.example.blogmultiplatform.pages.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.blogmultiplatform.models.Category
import com.example.blogmultiplatform.models.Constants.CATEGORY_PARAM
import com.example.blogmultiplatform.util.searchPostsByCategory
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext

@Page(routeOverride = "query")
@Composable
fun SearchPage() {
    val context = rememberPageContext()
    val postsToSkip by remember { mutableStateOf(0) }
    val hasCategoryParam = remember(key1 = context.route) {
        context.route.params.containsKey(CATEGORY_PARAM)
    }
    val value = remember(key1 = context.route) {
        if (hasCategoryParam) {
            context.route.params.getValue(CATEGORY_PARAM)
        } else {
            ""
        }
    }

    LaunchedEffect(key1 = context.route) {
        if (hasCategoryParam) {
            searchPostsByCategory(
                category = Category.valueOf(value),
                skip = postsToSkip,
                onSuccess = {

                },
                onError = {

                }
            )
        }
    }
}