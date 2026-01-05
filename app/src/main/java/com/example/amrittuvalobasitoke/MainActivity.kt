package com.example.amrittuvalobasitoke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.amrittuvalobasitoke.ui.theme.AmrittuValobasiTokeTheme
import com.example.amrittuvalobasitoke.ui.navigation.NavGraph

/**
 * Entry point of the application.
 * Sets the Compose content and applies the custom Material3 theme.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmrittuValobasiTokeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier, color = androidx.compose.material3.MaterialTheme.colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }
}

/**
 * Wrapper composable that hosts the navigation graph.
 */
@Composable
fun AppNavigation() {
    NavGraph()
}
