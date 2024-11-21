package com.example.simplequotesapplication.ui.theme.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplequotesapplication.ui.theme.DataManager
import com.example.simplequotesapplication.ui.theme.model.Quote



@Composable
fun QouteDetails(quote:Quote) {

    BackHandler {
        DataManager.switchPages(null)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0XFFffffff),
                        Color(0XFFE3E3E3)
                    )
                )
            ),
        contentAlignment = Alignment.Center // This centers the content
    ) {
        Card(
            modifier = Modifier.padding(32.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center, // Vertical centering inside the Column
                modifier = Modifier
                    .padding(16.dp, 24.dp) // Removed align here
            ) {
                Image(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)

                )

                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
