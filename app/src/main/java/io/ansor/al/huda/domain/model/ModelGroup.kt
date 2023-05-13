package io.ansor.al.huda.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.ansor.al.huda.R

enum class ModelGroup(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    val units: List<ModelUnit>,
) {
    PLANETS(
        icon = R.drawable.ic_sun, title = R.string.planets, units = listOf(
            ModelUnit(title = "Earth", animation = "earth.glb", scale = 0.1F),
        )
    )
}