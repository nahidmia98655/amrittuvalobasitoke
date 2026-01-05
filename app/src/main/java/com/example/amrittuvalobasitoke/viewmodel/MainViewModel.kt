package com.example.amrittuvalobasitoke.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
 * Simple data class representing a love story.
 */
data class Story(
    val id: Int,
    val title: String,
    val preview: String,
    val content: String
)

/**
 * ViewModel holding a list of stories and exposing them via StateFlow.
 * In a real app this could be backed by a repository / database.
 */
class MainViewModel : ViewModel() {
    // Internal mutable list of stories
    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    // Public read‑only flow
    val storyList: StateFlow<List<Story>> = _stories.asStateFlow()

    init {
        // Populate with some sample data
        viewModelScope.launch {
            _stories.value = listOf(
                Story(
                    id = 0,
                    title = "First Glance",
                    preview = "The moment our eyes met...",
                    content = "The moment our eyes met, I felt a spark that would later become a flame..."
                ),
                Story(
                    id = 1,
                    title = "Rainy Day",
                    preview = "Under the umbrella, we found shelter...",
                    content = "Under the umbrella, we found shelter from the rain, but more importantly, we found each other..."
                ),
                Story(
                    id = 2,
                    title = "Midnight Walk",
                    preview = "Strolling under the stars...",
                    content = "Strolling under the stars, we whispered dreams that felt as endless as the night sky..."
                )
            )
        }
    }

    /**
     * Returns a flow emitting a single story matching the given id.
     */
    fun getStoryById(id: Int): StateFlow<Story?> {
        return _stories.map { list -> list.find { it.id == id } }.asStateFlow()
    }
}
