package com.example.simplequotesapplication.ui.theme.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.simplequotesapplication.ui.theme.model.Quote

@Composable
fun QuoteList(data:Array<Quote>,onClick: ()-> Unit) {
    LazyColumn {
        items(data){
          QouteListItem(quote = it) {
              onClick()
          }  
        }
    }
}