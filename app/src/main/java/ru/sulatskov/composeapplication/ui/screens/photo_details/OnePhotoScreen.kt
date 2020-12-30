package ru.sulatskov.composeapplication.ui.screens.photo_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun PhotoDetailScreen(navHostController: NavHostController, id: Long) {

    ConstraintLayout {
        val (button, image) = createRefs()

        Button(onClick = { navHostController.navigate("photos") },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }) {
            Text(text = id.toString())

        }

        GlideImage(
            data = "https://images.unsplash.com/photo-1606851447920-549ba0b02246?ixid=MXwxOTM1MDR8MXwxfGFsbHwxfHx8fHx8Mnw&ixlib=rb-1.2.1",
            fadeIn = true,
            contentScale = ContentScale.FillBounds,
            loading = {
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        color = Color.Green,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            modifier = Modifier.constrainAs(image) {
                top.linkTo(button.bottom, margin = 16.dp)
            }
        )
    }

}