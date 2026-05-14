package com.example.karunada_vanya

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun GuideScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),

        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Co-Existence Guide",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1B5E20)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "What to do if an elephant enters your field:",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("• Stay calm and avoid loud noises")
        Spacer(modifier = Modifier.height(8.dp))

        Text("• Do not use flashlights directly")
        Spacer(modifier = Modifier.height(8.dp))

        Text("• Keep safe distance")
        Spacer(modifier = Modifier.height(8.dp))

        Text("• Inform forest department immediately")
        Spacer(modifier = Modifier.height(8.dp))

        Text("• Avoid blocking animal paths")

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Leopard Safety Tips:",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("• Avoid walking alone at night")
        Spacer(modifier = Modifier.height(8.dp))

        Text("• Keep livestock protected")
        Spacer(modifier = Modifier.height(8.dp))

        Text("• Do not approach leopard sightings")
        Spacer(modifier = Modifier.height(8.dp))

        Text("• Alert nearby villagers safely")
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "What to do if a tiger is spotted nearby",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "• Stay calm and avoid running\n" +
                    "• Do not approach the tiger\n" +
                    "• Move slowly to a safe place\n" +
                    "• Inform forest officials immediately",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "What to do if a black panther is spotted",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "• Keep a safe distance\n" +
                    "• Avoid travelling alone at night\n" +
                    "• Never feed wild animals\n" +
                    "• Alert nearby people carefully",
            fontSize = 18.sp
        )
    }
}