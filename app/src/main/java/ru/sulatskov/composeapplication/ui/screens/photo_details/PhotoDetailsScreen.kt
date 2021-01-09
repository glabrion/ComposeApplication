package ru.sulatskov.composeapplication.ui.screens.photo_details

import android.content.Context
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.chrisbanes.accompanist.glide.GlideImage
import ru.sulatskov.composeapplication.R
import ru.sulatskov.composeapplication.common.TimeUtils
import ru.sulatskov.composeapplication.model.network.dto.Photo
import ru.sulatskov.composeapplication.ui.main.MainViewModel
import ru.sulatskov.composeapplication.ui.theme.JetTheme

@Composable
fun PhotoDetailScreen(
    navHostController: NavHostController,
    viewModel: MainViewModel,
    id: String,
    context: Context
) {
    viewModel.getPhoto(id)
    val photo: Photo? by viewModel.photo.observeAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    photo?.user?.name?.let { Text(text = it) }
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
        Surface(
            color = JetTheme.colors.background,
            modifier = Modifier
                .fillMaxSize()
        ) {
            ScrollableColumn {
                ConstraintLayout {
                    val (profileImage, username, image, like) = createRefs()

                    photo?.user?.profileImage?.medium?.let {
                        GlideImage(
                            data = it,
                            fadeIn = true,
                            contentScale = ContentScale.None,
                            loading = {
                                Box(Modifier.fillMaxSize()) {
                                    CircularProgressIndicator(
                                        color = JetTheme.colors.text,
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }
                            },
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp)
                                .constrainAs(profileImage) {
                                    top.linkTo(parent.top, margin = 16.dp)
                                    start.linkTo(parent.start, margin = 16.dp)
                                }
                                .clip(RoundedCornerShape(14.dp))
                        )
                    }

                    photo?.user?.username?.let {
                        Column(
                            modifier = Modifier
                                .constrainAs(username) {
                                    start.linkTo(profileImage.end, margin = 16.dp)
                                    top.linkTo(profileImage.top)
                                    bottom.linkTo(profileImage.bottom)
                                }) {
                            Text(
                                text = it,
                                style = JetTheme.typography.textSmallBold
                            )
                            photo?.location?.title?.let {
                                Text(
                                    text = it,
                                    style = JetTheme.typography.textSmall
                                )
                            }
                        }
                    }

                    photo?.urls?.regular?.let {
                        GlideImage(
                            data = it,
                            fadeIn = true,
                            contentScale = ContentScale.Fit,
                            loading = {
                                Box(Modifier.fillMaxSize()) {
                                    CircularProgressIndicator(
                                        color = Color.Black,
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }
                            },
                            modifier = Modifier
                                .height(250.dp)
                                .fillMaxWidth()
                                .constrainAs(image) {
                                    top.linkTo(profileImage.bottom, margin = 16.dp)
                                }
                        )
                    }

                    Column(modifier = Modifier.constrainAs(like) {
                        top.linkTo(image.bottom, margin = 16.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                    }) {
                        photo?.likes?.let { likes ->
                            Row {
                                Text(
                                    style = JetTheme.typography.textSmallBold,
                                    text = stringResource(R.string.likes),
                                )
                                Text(
                                    style = JetTheme.typography.textSmallBold,
                                    text = likes.toString(),
                                    modifier = Modifier.padding(start = 4.dp)
                                )
                            }
                        }

                        photo?.description?.let {

                            Row(
                                modifier = Modifier
                                    .padding(top = 4.dp, end = 16.dp)
                            ) {
                                photo?.user?.username?.let { username ->
                                    Text(
                                        style = JetTheme.typography.textSmallBold,
                                        text = username,
                                    )
                                }
                                Text(
                                    style = JetTheme.typography.textSmall,
                                    text = it,
                                    modifier = Modifier.padding(start = 6.dp, end = 16.dp)
                                )
                            }
                        }

                        photo?.createdAt?.let {
                            Text(
                                style = JetTheme.typography.textSmallerLight,
                                text = TimeUtils.getDate(context, it),
                                modifier = Modifier
                                    .padding(top = 4.dp, end = 16.dp, bottom = 16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


