package io.ansor.al.huda.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.ansor.al.huda.R
import io.ansor.al.huda.presentation.common.SelectionItemModel


enum class SettingsMenu(
    @DrawableRes override val icon: Int,
    @StringRes override val title: Int,
) : SelectionItemModel {

    APP_LANGUAGE(
        icon = R.drawable.ic_language,
        title = R.string.system_language,
    ),
    ABOUT(
        icon = R.drawable.ic_about,
        title = R.string.about,
    ),
    DARK_THEME(
        icon = R.drawable.ic_moon,
        title = R.string.dark_theme,
    )
}