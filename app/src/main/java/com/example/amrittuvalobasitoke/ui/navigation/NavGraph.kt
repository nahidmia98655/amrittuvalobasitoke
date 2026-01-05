package com.example.amrittuvalobasitoke.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.amrittuvalobasitoke.ui.screens.DetailScreen
import com.example.amrittuvalobasitoke.ui.screens.HomeScreen

/**
 * Navigation routes used in the app.
 */
private object Routes {
    const val Home = "home"
    const val Detail = "detail"
}

/**
 * Host that defines the navigation graph.
 */
@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.Home,
        modifier = modifier
    ) {
        composable(Routes.Home) {
            HomeScreen(onStoryClick = { storyId ->
                navController.navigate("${Routes.Detail}/$storyId")
            })
        }
        composable(
            route = "${Routes.Detail}/{storyId}",
            arguments = listOf(navArgument("storyId") { type = NavType.IntType })
        ) { backStackEntry ->
            val storyId = backStackEntry.arguments?.getInt("storyId") ?: -1
            DetailScreen(storyId = storyId, onBack = { navController.popBackStack() })
        }
    }
}
