package com.example.task5

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.task5.ui.theme.Task5Theme

@Composable
fun BottomNavigation(navController: NavController) {
    val listItems = listOf(
        BottomItem.Home,
        BottomItem.Profile,
        BottomItem.Settings,
    )

    androidx.compose.material.BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRout = backStackEntry?.destination?.route
        listItems.forEach {
            BottomNavigationItem(selected = currentRout == it.route,
                onClick = {
                          navController.navigate(it.route)
                },
                icon = {
                    Icon(painter = painterResource(id = it.icon), contentDescription = "Icon")
                },
                label = {
                    Text(text = it.title)
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    Task5Theme {
        BottomNavigation(NavController(LocalContext.current))
    }
}