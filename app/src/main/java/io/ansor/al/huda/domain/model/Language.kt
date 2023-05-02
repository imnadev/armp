package io.ansor.al.huda.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.ansor.al.huda.R
import io.ansor.al.huda.presentation.common.SelectionItemModel

enum class Language(
    @DrawableRes override val icon: Int,
    @StringRes override val title: Int,
) : SelectionItemModel {
    UZ(R.drawable.ic_flag_uzbekistan, R.string.lan_uzbek),
    EN(R.drawable.ic_flag_britain, R.string.lan_english),
    RU(R.drawable.ic_flag_russia, R.string.lan_russian),
}