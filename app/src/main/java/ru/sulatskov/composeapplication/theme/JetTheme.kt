package ru.sulatskov.composeapplication.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.staticAmbientOf

@Composable
fun JetTheme(
    typography: JetTypography = JetTypography(),
    content: @Composable() () -> Unit
) {
    val colors = JetColorPalette()
    Providers(
        AmbientJetColor provides colors,
        AmbientJetTypography provides typography,
    ) {
        MaterialTheme(
            colors = colors.materialColors,
            typography = typography.materialTypography
        ) {
            content()
        }
    }
}

object JetTheme {
    @Composable
    val colors: JetColorPalette
        get() = AmbientJetColor.current

    @Composable
    val typography: JetTypography
        get() = AmbientJetTypography.current

    @Composable
    val sizes: JetSizes
        get() = JetSizes()
}

internal val AmbientJetColor = staticAmbientOf { JetColorPalette() }
internal val AmbientJetTypography = staticAmbientOf { JetTypography() }