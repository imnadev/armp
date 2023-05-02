package io.ansor.al.huda.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelUnit(
    val title: String,
    val subtitle: String? = null,
    val animation: String,
    val scale: Float = 1f
) : Parcelable
