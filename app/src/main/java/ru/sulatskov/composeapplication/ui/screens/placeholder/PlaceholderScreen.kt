package ru.sulatskov.composeapplication.ui.screens.placeholder

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.sulatskov.composeapplication.R
import ru.sulatskov.composeapplication.ui.theme.JetTheme

@Composable
fun PlaceholderScreen() {
    Text(
        text = stringResource(R.string.error_internet_connection),
        style = JetTheme.typography.textMedium,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentSize(Alignment.Center)
    )
}