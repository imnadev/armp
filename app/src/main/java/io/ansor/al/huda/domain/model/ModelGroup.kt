package io.ansor.al.huda.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.ansor.al.huda.R

enum class ModelGroup(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    val units: List<ModelUnit>,
) {
    CARS(
        icon = R.drawable.ic_car, title = R.string.transport, units = listOf(
            ModelUnit(
                title = "Alfa Romeo",
                subtitle = "Stradale 1967",
                animation = "alfa_romeo.glb",
                scale = 2F,
            ), ModelUnit(
                title = "Futuristic Car",
                animation = "futuristic_car.glb",
                scale = 0.1F,
            )
        )
    ),
    PLANETS(
        icon = R.drawable.ic_sun, title = R.string.planets, units = listOf(
            ModelUnit(title = "Earth", animation = "earth.glb", scale = 0.1F),
            ModelUnit(title = "Jupiter", animation = "jupiter.glb", scale = 0.01F),
        )
    ),
    ANIMALS(
        icon = R.drawable.ic_forest, title = R.string.animals, units = listOf(
            ModelUnit(
                title = "Rhino",
                subtitle = "Southern White Rhino",
                animation = "rhino.glb",
                scale = 0.1F,
            ),
            ModelUnit(
                title = "Turtle",
                subtitle = "Loggerhead Sea Turtle",
                animation = "turtle.glb",
                scale = 0.01F,
            ),
        )
    ),
    DINOSAURS(
        icon = R.drawable.ic_sun, title = R.string.dinosaurs, units = listOf(
            ModelUnit(
                title = "Tyrannosaurus Rex",
                animation = "tyrannosaurus_rex.glb",
                scale = 0.1F,
            ),
            ModelUnit(
                title = "Pteradactal",
                animation = "pteradactal.glb",
                scale = 0.2F,
            )
        )
    )
}