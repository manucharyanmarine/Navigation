package com.example.task5.ui.dialog

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task5.R

@Composable
fun CloseAppDialog(onConfirm: () -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = stringResource(R.string.close_app),
                color = Color.Red,
                fontSize = 40.sp
            )
        },
        text = { Text(text = stringResource(R.string.question)) },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm()
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(stringResource(R.string.close), color = Color.White)
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    onDismiss()
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(stringResource(R.string.cancel))
            }
        }
    )
}