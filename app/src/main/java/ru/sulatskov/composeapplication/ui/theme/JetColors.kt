package ru.sulatskov.composeapplication.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object JetColors {
    val primary = Color(0xFF1B8CD6)
    val background = Color(0xFF919191)
    val text = Color(0xFF000000)
    val toolbar = Color(0xFFFFFFFF)
}

class JetColorPalette() {
    val primary: Color = JetColors.primary
    val background: Color = JetColors.background
    val text: Color = JetColors.text
    val toolbar: Color = JetColors.toolbar

    val materialColors: Colors = lightColors(
        primary = JetColors.primary,
        surface = JetColors.background,
        onSurface = JetColors.text
    )
}