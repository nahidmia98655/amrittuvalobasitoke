package com.example.amrittuvalobasitoke.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amrittuvalobasitoke.viewmodel.MainViewModel

/**
 * Detail screen that shows a full story.
 */
@Composable
fun DetailScreen(
    storyId: Int,
    onBack: () -> Unit,
    viewModel: MainViewModel = viewModel()
) {
    val story by viewModel.getStoryById(storyId).collectAsState(initial = null)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = story?.title ?: "Story") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(text = story?.content ?: "Loading...")
        }
    }
}
