package com.stevdza.san.androidapp.navigation.destinations

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.stevdza.san.androidapp.models.Category
import com.stevdza.san.androidapp.navigation.Screen
import com.stevdza.san.androidapp.screens.category.CategoryScreen
import com.stevdza.san.androidapp.screens.category.CategoryViewModel
import com.stevdza.san.androidapp.util.Constants.CATEGORY_ARGUMENT

fun NavGraphBuilder.categoryRoute(
    onBackPress: () -> Unit,
    onPostClick: (String) -> Unit
) {
    composable(
        route = Screen.Category.route,
        arguments = listOf(navArgument(name = CATEGORY_ARGUMENT) {
            type = NavType.StringType
        })
    ) {
        val viewModel: CategoryViewModel = viewModel()
        val selectedCategory = it.arguments?.getString(CATEGORY_ARGUMENT) ?: Category.Programming.name
        CategoryScreen(
            posts = viewModel.categoryPosts.value,
            category = Category.valueOf(selectedCategory),
            onBackPress = onBackPress,
            onPostClick = onPostClick
        )
    }
}