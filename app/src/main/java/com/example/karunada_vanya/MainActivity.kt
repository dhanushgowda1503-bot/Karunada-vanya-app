package com.example.karunada_vanya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.karunada_vanya.components.WildlifeCard
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "splash"
            ) {

                composable(route = "splash") {
                    SplashScreen(navController)
                }
                composable("home") {
                    HomeScreen(navController)
                }
                composable("wildlife_card") {

                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {

                        WildlifeCard(
                            title = "Tiger",
                            description = "Tiger is India's national animal and an apex predator.",
                            imageRes = R.drawable.tiger
                        )

                        WildlifeCard(
                            title = "Elephant",
                            description = "Elephants are highly intelligent and social animals.",
                            imageRes = R.drawable.elephant
                        )

                        WildlifeCard(
                            title = "Black Panther",
                            description = "Black panther is a melanistic leopard found in forests.",
                            imageRes = R.drawable.blackpanther
                        )

                        WildlifeCard(
                            title = "Hornbill",
                            description = "Hornbills are famous for their large curved beaks.",
                            imageRes = R.drawable.hornbill
                        )

                        WildlifeCard(
                            title = "Sandalwood Tree",
                            description = "Sandalwood trees are valuable and known for fragrant wood.",
                            imageRes = R.drawable.sandalwood
                        )
                    }
                }
                composable("chatbot") {
                    ChatbotScreen()
                }

                composable("wiki") {
                    WikiScreen(navController)
                }

                composable("alerts") {
                    AlertScreen(navController)
                }

                composable("sounds") {
                    SoundScreen(navController)
                }

                composable("guide") {
                    GuideScreen(navController)
                }
            }
        }
    }
}
            @Composable
            fun HomeScreen(navController: NavHostController) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF5F5DC))
                        .verticalScroll(rememberScrollState())
                        .padding(20.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "🐅 Karunada-Vanya",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2E7D32)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.tiger),
                        contentDescription = "Tiger",
                        modifier = Modifier.size(220.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            navController.navigate("wiki")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF3949AB)
                        )
                    ) {
                        Text(
                            text = "\uD83D\uDCD5Wildlife Wiki",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            navController.navigate("alerts")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00897B)
                        )
                    ) {
                        Text(
                            text = "\uD83D\uDEA8Movement Alerts",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            navController.navigate("sounds")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6D4C41)
                        )
                    ) {
                        Text(
                            text = "\uD83D\uDD0AForest Sounds",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            navController.navigate("guide")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF9A825)
                        )
                    ) {
                        Text(
                            text = "\uD83D\uDCA1Co-existence Guide",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            navController.navigate("chatbot")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD81B60)
                        )
                    ) {
                        Text(
                            text = "\uD83E\uDD16AI Chatbot",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                        Spacer(modifier = Modifier.height(30.dp))

                        Text(
                            text = "Protect Wildlife • Protect Nature 🐅🌿",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Built with Jetpack Compose & GenAI",
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    }

                }

