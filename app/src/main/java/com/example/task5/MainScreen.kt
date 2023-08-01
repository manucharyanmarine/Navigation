package com.example.task5

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.task5.ui.theme.Task5Theme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        NavGraph(navHostController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Task5Theme {
        MainScreen()
    }
}