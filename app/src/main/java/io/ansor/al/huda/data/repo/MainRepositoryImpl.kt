package io.ansor.al.huda.data.repo

import io.ansor.al.huda.data.store.AppLanguageStore
import io.ansor.al.huda.data.store.OnBoardingStore
import io.ansor.al.huda.data.store.ThemeStore
import io.ansor.al.huda.domain.model.Language
import io.ansor.al.huda.domain.repo.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val appLanguageStore: AppLanguageStore,
    private val themeStore: ThemeStore,
    private val onBoardingStore: OnBoardingStore
) : MainRepository {

    override fun getOnboarding(): Flow<Boolean?> = onBoardingStore.getFlow()

    override fun getDarkTheme(): Flow<Boolean?> = themeStore.getFlow()

    override fun getLanguage(default: Language): Flow<Language> = appLanguageStore.getFlow(default)

    override fun setOnboarding(show: Boolean): Flow<Unit> = flow {
        onBoardingStore.set(show)
        emit(Unit)
    }.flowOn(Dispatchers.IO)

    override fun setDarkTheme(isDark: Boolean): Flow<Unit> = flow {
        themeStore.set(isDark)
        emit(Unit)
    }.flowOn(Dispatchers.IO)

    override fun setLanguage(language: Language): Flow<Unit> = flow {
        appLanguageStore.set(language)
        emit(Unit)
    }.flowOn(Dispatchers.IO)
}