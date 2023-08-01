package com.example.task5

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task5.ui.theme.Task5Theme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(R.color.yellow)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_home),
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )
        Text(
            text = stringResource(R.string.home),
            fontSize = 30.sp
        )
    }
}


@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(R.color.purple_200)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_profile),
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )
        Text(
            text = stringResource(R.string.profile),
            fontSize = 30.sp
        )
    }
}

@Composable
fun SettingsNestedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(R.color.green)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_app_settings),
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )
        Text(
            text = stringResource(R.string.nested_page),
            fontSize = 30.sp
        )
    }
}

@Composable
fun SettingsScreen(goToHomePage: () -> Unit, nestedPage: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(R.color.blue)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val showDialog = remember { mutableStateOf(false) }

        fun showCloseAppDialog() {
            showDialog.value = true
        }
        Image(
            painter = painterResource(R.drawable.ic_settings),
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )
        Text(
            text = stringResource(R.string.settings),
            fontSize = 30.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(modifier = Modifier.padding(20.dp), onClick = { goToHomePage() }) {
                Text(
                    text = stringResource(id = R.string.home)
                )
            }
            Button(modifier = Modifier.padding(20.dp), onClick = { nestedPage() }) {
                Text(
                    text = stringResource(id = R.string.nested_page)
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(20.dp)
                .clickable { showCloseAppDialog() },
            text = stringResource(id = R.string.close_app),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )

        val context = LocalContext.current

        if (showDialog.value) {
            CloseAppDialog(
                onConfirm = {
                    // Perform action to close the app here
                    if (context is Activity) {
                        context.finishAffinity()
                    }
                },
                onDismiss = {
                    showDialog.value = false
                }
            )
        }
    }

}

@Composable
fun CloseAppDialog(onConfirm: () -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Close App", color = Color.Red, fontSize = 40.sp) },
        text = { Text(text = "Are you sure you want to close the app?") },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm()
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text("Close", color = Color.White)
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    onDismiss()
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text("Cancel")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Task5Theme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    Task5Theme {
        ProfileScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    Task5Theme {
        SettingsScreen({},{})
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsNestedScreenPreview() {
    Task5Theme {
        SettingsNestedScreen()
    }
}