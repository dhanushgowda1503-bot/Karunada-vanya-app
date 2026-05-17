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
import android.annotation.SuppressLint
import android.location.Location
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.FusedLocationProviderClient
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import android.location.Geocoder
import java.util.Locale
import com.google.android.gms.location.Priority
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.content.Intent
import android.net.Uri
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

@Composable
fun AlertScreen(navController: NavHostController) {

    val context = LocalContext.current
    val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)
    var currentVillage by remember {
        mutableStateOf("Unknown Village")
    }

    var currentForest by remember {
        mutableStateOf("Unknown Forest Area")
    }
    var showEmergencyDialog by remember {
        mutableStateOf(false)
    }
    @SuppressLint("MissingPermission")
    fun getLocation() {

        fusedLocationClient.getCurrentLocation(
            Priority.PRIORITY_HIGH_ACCURACY,
            null
        )
            .addOnSuccessListener { location: Location? ->

                if (location != null) {

                    val geocoder = Geocoder(context, Locale.getDefault())

                    val addresses = geocoder.getFromLocation(
                        location.latitude,
                        location.longitude,
                        1
                    )

                    if (!addresses.isNullOrEmpty()) {

                        val address = addresses[0]

                        currentVillage =
                            address.subLocality
                                ?: address.locality
                                        ?: address.featureName
                                        ?: "Nearby Village"

                        currentForest =
                            address.subAdminArea
                                ?: address.adminArea
                                        ?: "Forest Area"
                    }

                } else {

                    currentVillage = "Village not found"

                    currentForest = "Forest not found"
                }
            }
    }
    LaunchedEffect(Unit) {

        if (
            ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            getLocation()

        } else {

            currentForest = "Permission Denied"
        }

    }
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
                location = currentForest,
                timestamp = System.currentTimeMillis()
            ),

            AlertData(
                animal = "Elephant",
                location =currentForest,
                timestamp = System.currentTimeMillis()
            ),

            AlertData(
                animal = "Black Panther",
                location = currentForest,
                timestamp = System.currentTimeMillis()
            )
        )
    }


    val sixHours = 6 * 60 * 60 * 1000L

    alertList.removeAll { alert ->

        System.currentTimeMillis() - alert.timestamp > sixHours
    }
    fun showNotification(title: String, message: String) {

        val channelId = "wildlife_alerts"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                channelId,
                "Wildlife Alerts",
                NotificationManager.IMPORTANCE_HIGH
            )

            val manager =
                context.getSystemService(Context.NOTIFICATION_SERVICE)
                        as NotificationManager

            manager.createNotificationChannel(channel)
        }

        val builder =
            NotificationCompat.Builder(context, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()

        NotificationManagerCompat.from(context)
            .notify((0..1000).random(), builder)
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
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                showEmergencyDialog = true
            }
        ) {

            Text("Emergency Support")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Village: $currentVillage",
            fontSize = 18.sp
        )

        Text(
            text = "Forest Area: $currentForest",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))


        Spacer(modifier = Modifier.height(10.dp))

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
                    Text(
                        text = alert.message,
                        fontSize = 14.sp
                    )
                }

            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
            onClick = {

                val randomAlerts = listOf(

                    AlertData(
                        animal = "Tiger",
                        village = currentVillage,
                        location = currentForest,
                        danger = "High",
                        message = "Tiger movent detected near village road",
                        timestamp = System.currentTimeMillis()
                    ),

                    AlertData(
                        animal = "Elephant",
                        village = currentVillage,
                        location = currentForest,
                        danger = "Medium",
                        message = "Elephant movement detected near village road",
                        timestamp = System.currentTimeMillis()
                    ),

                    AlertData(
                        animal = "Black Panther",
                        village = currentVillage,
                        location = currentForest,
                        danger = "High",
                        message = "Black Panther movement detected near village road",
                        timestamp = System.currentTimeMillis()
                    )
                )

                val newAlert = randomAlerts.random()

                if (!alertList.contains(newAlert)) {
                    alertList.add(newAlert)
                    database.push().setValue(newAlert)
                    showNotification(
                        "⚠ ${newAlert.animal} Alert",
                        newAlert.message
                    )
                }



                Toast.makeText(
                    context,
                    "Alert Sent Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
            ) {
                Text("Send Alert")
            }


            if (showEmergencyDialog) {

                AlertDialog(

                    onDismissRequest = {
                        showEmergencyDialog = false
                    },

                    title = {
                        Text("Emergency Support")
                    },

                    text = {

                        Column {

                            Button(
                                onClick = {

                                    val intent = Intent(
                                        Intent.ACTION_DIAL,
                                        Uri.parse("tel:112")
                                    )

                                    context.startActivity(intent)
                                }
                            ) {
                                Text("Call Emergency")
                            }
                        }
                    },

                    confirmButton = {

                        Button(
                            onClick = {
                                showEmergencyDialog = false
                            }
                        ) {
                            Text("Close")
                        }
                    }
                )
            }

        }
        }
    }
