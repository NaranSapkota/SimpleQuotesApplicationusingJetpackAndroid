package com.example.simplequotesapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat.Style
import com.example.simplequotesapplication.ui.theme.DataManager
import com.example.simplequotesapplication.ui.theme.SimpleQuotesApplicationTheme
import com.example.simplequotesapplication.ui.theme.screens.QouteDetails
import com.example.simplequotesapplication.ui.theme.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            //delay(1000)
            DataManager.loadAssestsFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {

    if (DataManager.isDataLoaded.value) {


        if (DataManager.currentPage.value == Pages.LISTING) {

            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)

            }
        } else {
            DataManager.currentQuote?.let { QouteDetails(quote = it) }
        }

    } else {
        Box(modifier = Modifier.fillMaxSize(1f)) {
            Text(text = "Loading....", style = MaterialTheme.typography.bodyLarge)
        }

    }
}

enum class Pages {
    LISTING,
    DETAIL
}

