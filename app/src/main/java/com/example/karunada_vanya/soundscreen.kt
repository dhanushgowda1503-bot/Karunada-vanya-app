package com.example.karunada_vanya

import android.media.MediaPlayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SoundScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Forest Sounds",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                MediaPlayer.create(context, R.raw.tiger)?.start()
            }
        ) {
            Text("Play Tiger Sound")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                MediaPlayer.create(context, R.raw.elephant)?.start()
            }
        ) {
            Text("Play Elephant Sound")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                MediaPlayer.create(context, R.raw.bird)?.start()
            }
        ) {
            Text("Play Bird Sound")
        }
    }
}

