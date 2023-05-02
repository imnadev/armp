package io.ansor.al.huda.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorPalette = lightColors(
    background = Lotion,
    primary = White,
    secondary = Jet,
    onPrimary = EerieBlack,
    onSecondary = White,
    onSurface = GraniteGray,
    onError = MetallicBlue,
)

private val DarkColorPalette = darkColors(
    background = RaisinBlack,
    primary = Jet,
    secondary = White,
    onPrimary = White,
    onSecondary = CharlestonGreen,
    onSurface = GrayX11,
    onError = White,
)

@Composable
fun AlhudaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes
    ) {
        val systemUiController = rememberSystemUiController()

        systemUiController.setSystemBarsColor(
            color = colors.statusBar
        )

        // TODO back image
        content()
    }
}