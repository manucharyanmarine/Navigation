package com.example.task5

sealed class BottomItem(
    val title: String,
    val icon: Int,
    val route: String
){
    object Home: BottomItem("HOME",R.drawable.ic_home, "home")
    object Profile: BottomItem("Profile",R.drawable.ic_profile, "profile")
    object Settings: BottomItem("Settings",R.drawable.ic_settings, "settings")
}