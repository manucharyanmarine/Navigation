package com.example.task5

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("profile") {
            ProfileScreen()
        }
        composable("nested") {
            SettingsNestedScreen()
        }
        composable("settings") {
            SettingsScreen(
                {
                    navHostController.navigate("home") {
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                },
                { navHostController.navigate("nested") }
            )
        }
    }
}