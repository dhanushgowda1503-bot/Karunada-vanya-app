

package com.example.karunada_vanya

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun ChatbotScreen() {

    var question by remember {
        mutableStateOf("")
    }

    var response by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "🤖 Wildlife AI Assistant",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2E7D32)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = question,
            onValueChange = {
                question = it
            },
            label = {
                Text("Ask about wildlife...")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                response = when {

                    question.contains("tiger", ignoreCase = true) ->
                        "Stay indoors and inform forest officials immediately."

                    question.contains("elephant", ignoreCase = true) ->
                        "Keep distance from elephants and avoid loud sounds."

                    question.contains("black panther", ignoreCase = true) ->
                        "Do not approach the animal. Alert forest department."

                    question.contains("hornbill", ignoreCase = true) ->
                        "Hornbills help forests by spreading seeds."

                    question.contains("sandalwood", ignoreCase = true) ->
                        "Sandalwood trees are protected forest species."

                    else ->
                        "Please ask wildlife related questions."
                }
            }
        ) {
            Text("Ask AI")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE8F5E9)
            )
        ) {

            Text(
                text = response,
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp
            )
        }
    }
}