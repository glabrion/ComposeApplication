package ru.sulatskov.composeapplication.ui.screens.photos_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import dev.chrisbanes.accompanist.glide.GlideImage
import ru.sulatskov.composeapplication.common.visible
import ru.sulatskov.composeapplication.model.network.dto.Photo
import ru.sulatskov.composeapplication.ui.main.MainViewModel


@Composable
fun PhotosListScreen(
    navHostController: NavHostController,
    viewModel: MainViewModel
) {
    val photos: List<Photo> by viewModel.photosList.observeAsState(listOf())
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)
    PhotosListContent(photos, isLoading, navHostController)
}

@Composable
fun PhotosListContent(
    items: List<Photo>?,
    isLoading: Boolean,
    navHostController: NavHostController
) {

    ConstraintLayout {
        val (button, progress, image) = createRefs()

        Button(onClick = { navHostController.navigate("photo/${1}") },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }) {
            Text(text = items?.firstOrNull()?.id.toString())

        }

        CircularProgressIndicator(
            modifier = Modifier.constrainAs(progress) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.visible(isLoading)
        )

        items?.firstOrNull()?.urls?.full?.let {
            GlideImage(
                data = it,
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
}

