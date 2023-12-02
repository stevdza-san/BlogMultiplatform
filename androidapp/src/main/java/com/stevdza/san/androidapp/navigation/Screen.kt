package com.stevdza.san.androidapp.navigation

import com.stevdza.san.androidapp.util.Constants.CATEGORY_ARGUMENT
import com.stevdza.san.androidapp.util.Constants.POST_ID_ARGUMENT
import com.example.shared.Category as PostCategory

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home_screen")
    data object Category : Screen(route = "category_screen/{${CATEGORY_ARGUMENT}}") {
        fun passCategory(category: PostCategory) = "category_screen/${category.name}"
    }

    data object Details : Screen(route = "details_screen/{${POST_ID_ARGUMENT}}") {
        fun passPostId(id: String) = "details_screen/${id}"
    }
}
