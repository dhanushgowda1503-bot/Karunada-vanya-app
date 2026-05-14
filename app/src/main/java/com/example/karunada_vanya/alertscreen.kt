package com.example.karunada_vanya

import com.google.firebase.database.FirebaseDatabase
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.karunada_vanya.data.AlertData
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun AlertScreen(navController: NavHostController) {

    val context = LocalContext.current
    val database = FirebaseDatabase
        .getInstance()
        .reference
        .child("alerts")

    var alertText by remember {
        mutableStateOf("No wildlife alerts")
    }
    val alertList = remember {

        mutableStateListOf(

            AlertData(
                animal = "Tiger",
                location = "Bandipur Forest",
                timestamp = System.currentTimeMillis()
            ),

            AlertData(
                animal = "Elephant",
                location = "Nagarahole",
                timestamp = System.currentTimeMillis()
            ),

            AlertData(
                animal = "Black Panther",
                location = "Kabini Forest",
                timestamp = System.currentTimeMillis()
            )
        )
    }

    val sixHours = 6 * 60 * 60 * 1000L

    alertList.removeAll { alert ->

        System.currentTimeMillis() - alert.timestamp > sixHours
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Movement Alerts",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (alertList.isEmpty()) {

            Text(
                text = "No active wildlife alerts",
                fontSize = 18.sp
            )

        } else {

            alertList.forEach { alert ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),

                    colors = CardDefaults.cardColors(

                        containerColor = when (alert.animal) {

                            "Tiger" -> Color(0xFFFFE0B2)

                            "Elephant" -> Color(0xFFE1F5FE)

                            "Black Panther" -> Color(0xFFD7CCC8)

                            else -> Color.White
                        }
                    )
                ) {

                    Text(
                        text = "${alert.animal} spotted near ${alert.location}",
                        modifier = Modifier.padding(16.dp),
                        fontSize = 18.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
            onClick = {

                val randomAlerts = listOf(

                    AlertData(
                        animal = "Tiger",
                        location = "Bandipur Forest",
                        timestamp = System.currentTimeMillis()
                    ),

                    AlertData(
                        animal = "Elephant",
                        location = "Nagarahole",
                        timestamp = System.currentTimeMillis()
                    ),

                    AlertData(
                        animal = "Black Panther",
                        location = "Kabini Forest",
                        timestamp = System.currentTimeMillis()
                    )
                )

                val newAlert = randomAlerts.random()

                if (!alertList.contains(newAlert)) {
                    alertList.add(newAlert)
                    database.push().setValue(newAlert)
                }

                database.push().setValue(newAlert)

                Toast.makeText(
                    context,
                    "Alert Sent Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
            ) {
                Text("Send Alert")
            }
        }
    }
}