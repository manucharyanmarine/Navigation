package com.example.task5.ui.navigation

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.task5.R
import com.example.task5.ui.theme.Task5Theme

@Composable
fun BottomNavigation(navController: NavController, onItemClick: (BottomItem) -> Unit) {
    val listItems = listOf(
        BottomItem.Home,
        BottomItem.Profile,
        BottomItem.Settings,
    )

    NavigationBar {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRout = backStackEntry?.destination?.route
        listItems.forEach {
            BottomNavigationItem(
                selected = currentRout == it.route,
                onClick = {
                    onItemClick(it)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = stringResource(R.string.icon)
                    )
                },
                label = {
                    Text(text = it.title)
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    Task5Theme {
        BottomNavigation(NavController(LocalContext.current)) {}
    }
}