package com.stevdza.san.androidapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.stevdza.san.androidapp.screens.home.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(route = Screen.Category.route) {

        }
        composable(route = Screen.Details.route) {

        }
    }
}