package com.example.task5.ui.navigation

sealed class MainSetting(
    val route: String
) {
    object Setting : MainSetting("Setting")
    object SettingNested : MainSetting("Setting Nested")
}