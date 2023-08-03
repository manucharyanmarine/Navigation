package com.example.task5.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.task5.ui.home.HomeScreen
import com.example.task5.ui.navigation.BottomItem
import com.example.task5.ui.navigation.SettingGraph
import com.example.task5.ui.profile.ProfileScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = BottomItem.Home.route) {
        composable(BottomItem.Home.route) {
            HomeScreen()
        }
        composable(BottomItem.Profile.route) {
            ProfileScreen()
        }
        composable(BottomItem.Settings.route) {
            SettingGraph(navHostController = navHostController)
        }
    }
}