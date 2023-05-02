package io.ansor.al.huda.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import io.ansor.al.huda.R
import io.ansor.al.huda.presentation.destinations.HomeScreenDestination
import io.ansor.al.huda.presentation.destinations.SettingsScreenDestination

enum class BottomItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val direction: DirectionDestinationSpec
) {
    HOME(
        R.string.bottom_menu_home,
        R.drawable.ic_bot_home,
        HomeScreenDestination
    ),
    SETTINGS(
        R.string.settings,
        R.drawable.ic_bot_settings,
        SettingsScreenDestination
    )
}