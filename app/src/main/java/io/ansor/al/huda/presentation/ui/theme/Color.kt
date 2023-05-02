package io.ansor.al.huda.presentation.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val White = Color(0xFFFFFFFF)
val Jet = Color(0xFF343434)
val EerieBlack = Color(0xFF1C1C1E) // screen title
val CharlestonGreen = Color(0xFF2C2C2E) // icon(raw)
val GraniteGray = Color(0xFF666666) // subtitle,
val GrayX11 = Color(0xFFB9B9B9) // text rakat
val MetallicBlue = Color(0xFF305F72) // percentage
val Lotion = Color(0xFFFAFAFA) // play button background, **Back
val AntiFlashWhite = Color(0xFFF1F1F1) // toggle back
val Emerald = Color(0xFF4DD082) // radio
val CaribbeanGreen = Color(0xFF1AD285) // radio night
val RaisinBlack = Color(0xFF202020) // toggle disable back, **Back
val OuterSpace = Color(0xFF464646) // bottom night selected bg
val BrightGray = Color(0xFFEAEAEA)
val Line = Color(0x80B9B9B9)

val Colors.buttonBackground: Color
    get() = if (isLight) CharlestonGreen else White

val Colors.bodyWithOpacity: Color
    get() = if (isLight) CharlestonGreen else White.copy(alpha = 0.8f)

val Colors.buttonText: Color
    get() = if (isLight) White else CharlestonGreen

val Colors.titleText: Color
    get() = if (isLight) EerieBlack else White

val Colors.iconTint: Color
    get() = if (isLight) CharlestonGreen else GrayX11

val Colors.layer: Color
    get() = if (isLight) White else Jet

val Colors.subtitleTextSection: Color
    get() = if (isLight) GraniteGray else GrayX11

val Colors.grayX11: Color get() = GrayX11

val Colors.playBackground: Color
    get() = if (isLight) Lotion else RaisinBlack

val Colors.bottomItemSelectedBackground: Color
    get() = if (isLight) CharlestonGreen else OuterSpace

val Colors.bottomIconUnselected: Color
    get() = if (isLight) GraniteGray else GrayX11

val Colors.switchSelected: Color
    get() = if (isLight) Emerald else CaribbeanGreen

val Colors.switchUnselected: Color
    get() = if (isLight) BrightGray else RaisinBlack

val Colors.statusBar: Color
    get() = if (isLight) White else Jet

val Colors.line: Color get() = Line

val Colors.animationBackground: Color
    get() = if (isLight) Lotion else RaisinBlack

val Colors.greenStroke: Color
    get() = Emerald
