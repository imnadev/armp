package io.ansor.al.huda.presentation.settings

import dagger.hilt.android.lifecycle.HiltViewModel
import io.ansor.al.huda.common.architecture.BaseViewModel
import io.ansor.al.huda.domain.model.Language
import io.ansor.al.huda.domain.repo.MainRepository
import io.ansor.al.huda.presentation.settings.SettingsViewModel.*
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val mainRepository: MainRepository,
) : BaseViewModel<State, Input, Effect>(State()) {

    init {
        getAppLanguage()
        getDarkTheme()
    }

    data class State(
        val appLanguage: Language = Language.UZ,
        val darkTheme: Boolean? = null,
    )

    sealed class Input {
        data class SetTheme(val isDark: Boolean) : Input()
    }

    class Effect

    override fun processInput(input: Input) {
        when (input) {
            is Input.SetTheme -> setTheme(input.isDark)
        }
    }

    private fun setTheme(isDark: Boolean) {
        mainRepository.setDarkTheme(isDark).launch()
    }

    private fun getDarkTheme() = mainRepository.getDarkTheme()
        .stateOnEach { state, value -> state.copy(darkTheme = value) }
        .launch()

    private fun getAppLanguage() = mainRepository.getLanguage(Language.UZ)
        .stateOnEach { state, value -> state.copy(appLanguage = value) }
        .launch()
}