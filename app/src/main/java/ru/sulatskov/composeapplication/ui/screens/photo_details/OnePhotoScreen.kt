package ru.sulatskov.composeapplication.ui.screens.photo_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.chrisbanes.accompanist.glide.GlideImage
import ru.sulatskov.composeapplication.model.network.dto.Photo
import ru.sulatskov.composeapplication.ui.main.MainViewModel
import ru.sulatskov.composeapplication.ui.theme.JetTheme

@Composable
fun PhotoDetailScreen(navHostController: NavHostController, viewModel: MainViewModel, id: String) {
    val photo: Photo? by viewModel.photo.observeAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Back"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack)
                    }
                },
                backgroundColor = JetTheme.colors.toolbar
            )
        }

    ) {
        Surface(color = JetTheme.colors.background) {
            ConstraintLayout {
                val (button, image) = createRefs()
                photo?.urls?.regular?.let {
                    GlideImage(
                        data = it,
                        fadeIn = true,
                        contentScale = ContentScale.Crop,
                        loading = {
                            Box(Modifier.fillMaxSize()) {
                                CircularProgressIndicator(
                                    color = Color.Black,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        },
                        modifier = Modifier.height(200.dp).fillMaxSize().constrainAs(image) {
                            top.linkTo(button.bottom, margin = 16.dp)
                        }
                    )

                }
            }
        }
    }


}