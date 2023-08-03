package com.example.task5.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.task5.ui.navigation.BottomItem
import com.example.task5.ui.navigation.MainSetting
import com.example.task5.ui.settings.SettingsNestedScreen
import com.example.task5.ui.settings.SettingsScreen

@Composable
fun SettingGraph(
    navHostController: NavHostController
) {
    val nestedNavController = rememberNavController()
    NavHost(navController = nestedNavController, startDestination = MainSetting.Setting.route) {
        composable(MainSetting.Setting.route) {
            SettingsScreen(
                goToHomePage = {
                    navHostController.navigate(BottomItem.Home.route) {
                        popUpTo(BottomItem.Home.route) {
                            inclusive = true
                        }
                    }
                },
                nestedNavHostController = nestedNavController
            )
        }
        composable(MainSetting.SettingNested.route) {
            SettingsNestedScreen()
        }
    }
}