package io.ansor.al.huda.domain.repo

import io.ansor.al.huda.domain.model.Language
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getOnboarding(): Flow<Boolean?>

    fun getDarkTheme(): Flow<Boolean?>

    fun getLanguage(default: Language): Flow<Language>

    fun setOnboarding(show: Boolean): Flow<Unit>

    fun setDarkTheme(isDark: Boolean): Flow<Unit>

    fun setLanguage(language: Language): Flow<Unit>
}