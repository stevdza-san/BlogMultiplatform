package com.stevdza.san.androidapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            HomeScreen(posts = viewModel.allPosts.value)
        }
        composable(route = Screen.Category.route) {

        }
        composable(route = Screen.Details.route) {

        }
    }
}