package io.ansor.al.huda.presentation

import io.ansor.al.huda.R
import io.ansor.al.huda.domain.model.Language

val Language.stringResource: Int
    get() = when (this) {
        Language.UZ -> R.string.lan_uzbek
        Language.EN -> R.string.lan_english
        Language.RU -> R.string.lan_russian
    }
