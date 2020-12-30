package ru.sulatskov.composeapplication.common

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

fun Modifier.visible(visibility: Boolean): Modifier {
    return if (visibility) {
        this.then(alpha(1f))
    } else {
        this.then(alpha(0f))
    }
}