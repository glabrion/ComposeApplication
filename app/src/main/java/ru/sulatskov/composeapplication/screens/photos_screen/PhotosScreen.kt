package ru.sulatskov.composeapplication.screens.photos_screen

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun PhotosScreen(navHostController: NavHostController){

    Button(onClick = { navHostController.navigate("photo/${1}") }) {
        Text(text = "button")
    }

}