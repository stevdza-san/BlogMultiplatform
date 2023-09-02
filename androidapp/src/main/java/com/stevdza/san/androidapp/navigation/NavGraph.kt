package com.stevdza.san.androidapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.stevdza.san.androidapp.models.Category
import com.stevdza.san.androidapp.screens.category.CategoryScreen
import com.stevdza.san.androidapp.screens.category.CategoryViewModel
import com.stevdza.san.androidapp.screens.details.DetailsScreen
import com.stevdza.san.androidapp.screens.home.HomeScreen
import com.stevdza.san.androidapp.screens.home.HomeViewModel

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            val viewModel: HomeViewModel = viewModel()
            var query by remember { mutableStateOf("") }
            var searchBarOpened by remember { mutableStateOf(false) }
            var active by remember { mutableStateOf(false) }

            HomeScreen(
                posts = viewModel.allPosts.value,
                searchedPosts = viewModel.searchedPosts.value,
                query = query,
                searchBarOpened = searchBarOpened,
                active = active,
                onActiveChange = { active = it },
                onQueryChange = { query = it },
                onCategorySelect = {
                    navController.navigate(Screen.Category.passCategory(it))
                },
                onSearchBarChange = { opened ->
                    searchBarOpened = opened
                    if (!opened) {
                        query = ""
                        active = false
                        viewModel.resetSearchedPosts()
                    }
                },
                onSearch = viewModel::searchPostsByTitle,
                onPostClick = { postId ->
                    navController.navigate(Screen.Details.passPostId(postId))
                }
            )
        }
        composable(
            route = Screen.Category.route,
            arguments = listOf(navArgument(name = "category") {
                type = NavType.StringType
            })
        ) {
            val viewModel: CategoryViewModel = viewModel()
            val selectedCategory = it.arguments?.getString("category") ?: Category.Programming.name
            CategoryScreen(
                posts = viewModel.categoryPosts.value,
                category = Category.valueOf(selectedCategory),
                onBackPress = { navController.popBackStack() },
                onPostClick = { postId ->
                    navController.navigate(Screen.Details.passPostId(postId))
                }
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(name = "postId") {
                type = NavType.StringType
            })
        ) {
            val postId = it.arguments?.getString("postId")
            DetailsScreen(
                url = "http://10.0.2.2:8080/posts/post?postId=$postId",
                onBackPress = { navController.popBackStack() }
            )
        }
    }
}