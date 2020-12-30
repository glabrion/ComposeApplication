package ru.sulatskov.composeapplication

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import ru.sulatskov.composeapplication.screens.photo_details.PhotoDetailScreen
import ru.sulatskov.composeapplication.screens.photos_list.PhotosListScreen
import ru.sulatskov.composeapplication.theme.JetColors
import ru.sulatskov.composeapplication.theme.JetTheme

@Composable
fun JetApp() {
    JetTheme {
        Surface(color = JetColors.background) {
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
}
