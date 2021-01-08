package ru.sulatskov.composeapplication.ui.main

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import ru.sulatskov.composeapplication.ui.screens.photo_details.PhotoDetailScreen
import ru.sulatskov.composeapplication.ui.screens.photos_list.PhotosListScreen
import ru.sulatskov.composeapplication.ui.theme.JetColors
import ru.sulatskov.composeapplication.ui.theme.JetTheme

@Composable
fun JetApp(viewModel: MainViewModel) {
    JetTheme {
        Surface(color = JetColors.background) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = NavScreen.PhotosList.route) {
                composable(NavScreen.PhotosList.route) {
                    PhotosListScreen(
                        navHostController = navController,
                        viewModel = viewModel
                    )
                }
                composable(
                    NavScreen.PhotosDetails.routeWithArgument,
                    arguments = listOf(navArgument(NavScreen.PhotosDetails.photoIdArgument) { type = NavType.StringType })
                ) { backStackEntry ->
                    backStackEntry.arguments?.getString(NavScreen.PhotosDetails.photoIdArgument)?.let { id ->
                        viewModel.getPhoto(id)
                        PhotoDetailScreen(navHostController = navController, viewModel = viewModel, id = id)
                    }
                }
            }
        }
    }
}

sealed class NavScreen(val route: String) {

    object PhotosList : NavScreen("Photos")

    object PhotosDetails : NavScreen("PhotosDetails") {

        const val routeWithArgument: String = "PhotosDetails/{photoId}"

        const val photoIdArgument: String = "photoId"
    }
}
