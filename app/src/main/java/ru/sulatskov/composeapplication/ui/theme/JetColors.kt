package ru.sulatskov.composeapplication.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object JetColors {

    val primary = Color(0xFF1B8CD6)
    val background = Color(0xFFF7F7F7)
    val text = Color(0xFF000000)
    val toolbar = Color(0xFFFFFFFF)
    val card = Color(0xFFFFFFFF)
    val textAccent = Color(0xFFAA3A3A)
}

class JetColorPalette() {
    val card: Color = JetColors.card
    val primary: Color = JetColors.primary
    val background: Color = JetColors.background
    val text: Color = JetColors.text
    val toolbar: Color = JetColors.toolbar
    val textAccent: Color = JetColors.textAccent

    val materialColors: Colors = lightColors(
        primary = JetColors.primary,
        surface = JetColors.background,
        onSurface = JetColors.text
    )
}