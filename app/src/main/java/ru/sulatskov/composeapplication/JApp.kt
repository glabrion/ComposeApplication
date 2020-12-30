package ru.sulatskov.composeapplication

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import ru.sulatskov.composeapplication.screens.photo_details.PhotoDetailScreen
import ru.sulatskov.composeapplication.screens.photos_list.PhotosListScreen

@Composable
fun JApp(){
    Surface(color = Color.DarkGray) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "photos") {
            composable("photos") {
                PhotosListScreen(
                    navHostController = navController
                )
            }
            composable(
                "photo/{photoId}",
                arguments = listOf(navArgument("photoId") { type = NavType.LongType })
            ) { backStackEntry ->
                backStackEntry.arguments?.getLong("photoId")?.let { id ->
                    PhotoDetailScreen(navHostController = navController, id)
                }
            }
        }
    }
}
