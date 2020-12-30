package ru.sulatskov.composeapplication.screens.one_photo

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun OnePhotoScreen(navHostController: NavHostController, id: Long){

    Button(onClick = { navHostController.navigate("photos") }) {
            Text(text = id.toString())
    }

}