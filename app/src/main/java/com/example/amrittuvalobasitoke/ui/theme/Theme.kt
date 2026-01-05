package com.example.amrittuvalobasitoke.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Purple500,
    secondary = Teal200,
    tertiary = Purple700
)

private val DarkColors = darkColorScheme(
    primary = Purple500,
    secondary = Teal200,
    tertiary = Purple700
)

/**
 * Application‑wide Material3 theme.
 * Switches between light/dark based on the system setting.
 */
@Composable
fun AmrittuValobasiTokeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colors,
        typography = androidx.compose.material3.Typography(),
        content = content
    )
}
