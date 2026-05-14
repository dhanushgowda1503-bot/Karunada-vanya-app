package com.example.karunada_vanya

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import com.example.karunada_vanya.components.WildlifeCard
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll



@Composable
fun WikiScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("⬅ Back")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Wildlife Wiki",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        WildlifeCard(
            title = "Tiger",
            description = "Tiger is India's national animal.",
            imageRes = R.drawable.tiger
        )
        Spacer(modifier = Modifier.height(16.dp))

        WildlifeCard(
            title = "Elephant",
            description = "Elephants are intelligent animals.",
            imageRes = R.drawable.elephant
        )
        Spacer(modifier = Modifier.height(16.dp))

        WildlifeCard(
            title = "Black Panther",
            description = "Black panther is a melanistic leopard.",
            imageRes = R.drawable.blackpanther
        )
        Spacer(modifier = Modifier.height(16.dp))

        WildlifeCard(
            title = "Hornbill",
            description = "Hornbill birds are known for their large beaks.",
            imageRes = R.drawable.hornbill
        )
        Spacer(modifier = Modifier.height(16.dp))

        WildlifeCard(
            title = "Sandalwood Tree",
            description = "Sandalwood trees are famous for fragrant wood.",
            imageRes = R.drawable.sandalwood
        )
    }
}


