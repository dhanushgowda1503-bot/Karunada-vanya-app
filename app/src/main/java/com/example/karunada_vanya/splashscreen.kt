

package com.example.karunada_vanya

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("home") {
            popUpTo("splash") {
                inclusive = true
            }
        }
    }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE8F5E9)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.tiger),
                contentDescription = "Tiger",
                modifier = Modifier.size(180.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Karunada-Vanya",
                fontSize = 34.sp,
                color = Color(0xFF1B5E20)
            )
        }
    }
