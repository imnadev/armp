package io.ansor.al.huda.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.ansor.al.huda.R

private val gilroyFonts = FontFamily(
    Font(R.font.gilroy_regular),
    Font(R.font.gilroy_medium, FontWeight.Medium),
    Font(R.font.gilroy_semibold, FontWeight.SemiBold),
    Font(R.font.gilroy_bold, FontWeight.Bold),
)

private val interFonts = FontFamily(
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val Typography.interExtraBold: TextStyle
    get() =
        TextStyle(
            fontFamily = interFonts,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )

val Typography.interBold: TextStyle
    get() =
        TextStyle(
            fontFamily = interFonts,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )


val Typography.interSemiBold: TextStyle
    get() =
        TextStyle(
            fontFamily = interFonts,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )

val Typography.interNormal: TextStyle
    get() =
        TextStyle(
            fontFamily = interFonts,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        )

val Typography.gilroyRegular: TextStyle
    get() =
        TextStyle(
            fontFamily = gilroyFonts,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )

val Typography.gilroySemiBold: TextStyle
    get() =
        TextStyle(
            fontFamily = gilroyFonts,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )

val Typography.gilroyMedium: TextStyle
    get() =
        TextStyle(
            fontFamily = gilroyFonts,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )

val Typography.gilroyBold: TextStyle
    get() =
        TextStyle(
            fontFamily = gilroyFonts,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )


