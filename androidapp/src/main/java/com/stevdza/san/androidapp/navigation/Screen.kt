package com.stevdza.san.androidapp.navigation

import com.stevdza.san.androidapp.models.Category as PostCategory

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Category : Screen(route = "category_screen/{category}") {
        fun passCategory(category: PostCategory) = "category_screen/${category.name}"
    }

    object Details : Screen(route = "details_screen/{postId}") {
        fun passPostId(id: String) = "details_screen/${id}"
    }
}
