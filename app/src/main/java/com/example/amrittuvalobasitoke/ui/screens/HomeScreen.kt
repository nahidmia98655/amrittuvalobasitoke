package com.example.amrittuvalobasitoke.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amrittuvalobasitoke.viewmodel.MainViewModel

/**
 * Home screen displaying a list of love stories.
 * Clicking on a card navigates to the detail screen.
 */
@Composable
fun HomeScreen(
    onStoryClick: (Int) -> Unit,
    viewModel: MainViewModel = viewModel()
) {
    val stories by viewModel.storyList.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(stories) { story ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp)
                    .clickable { onStoryClick(story.id) },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = story.title)
                    Text(text = story.preview, maxLines = 2)
                }
            }
        }
    }
}
