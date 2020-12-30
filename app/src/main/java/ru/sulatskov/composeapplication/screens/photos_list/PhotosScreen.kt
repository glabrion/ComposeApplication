package ru.sulatskov.composeapplication.screens.photos_list

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun PhotosListScreen(navHostController: NavHostController){



    ConstraintLayout {
        // Create references for the composables to constrain
        val (button) = createRefs()

        Button(onClick = { navHostController.navigate("photo/${1}") },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }) {
            Text(text = "button")

        }
    }

}