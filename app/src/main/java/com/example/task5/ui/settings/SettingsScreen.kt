package com.example.task5.ui.settings

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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.task5.ui.dialog.CloseAppDialog
import com.example.task5.ui.navigation.MainSetting
import com.example.task5.R
import com.example.task5.ui.theme.Task5Theme


@Composable
fun SettingsScreen(goToHomePage: () -> Unit, nestedNavHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(R.color.blue)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var showDialog by rememberSaveable { mutableStateOf(false) }

        fun showCloseAppDialog() {
            showDialog = true
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
            Button(modifier = Modifier.padding(20.dp), onClick = {
                nestedNavHostController.navigate(MainSetting.SettingNested.route)
            }) {
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

        if (showDialog) {
            CloseAppDialog(
                onConfirm = {
                    if (context is Activity) {
                        context.finishAffinity()
                    }
                },
                onDismiss = {
                    showDialog = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    Task5Theme {
        SettingsScreen({}, NavHostController(LocalContext.current))
    }
}