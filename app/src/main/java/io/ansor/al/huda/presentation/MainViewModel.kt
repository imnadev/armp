package io.ansor.al.huda.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import io.ansor.al.huda.common.architecture.BaseViewModel
import io.ansor.al.huda.domain.model.Language
import io.ansor.al.huda.domain.repo.MainRepository
import io.ansor.al.huda.presentation.MainViewModel.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel<State, Input, Effect>(State()) {

    init {
        getOnboarding()
        getAppLanguage()
        getDarkTheme()
    }

    data class State(
        val dark: Boolean? = null,
        val onboarding: Boolean? = true,
        val language: Language = Language.UZ
    )

    class Input

    class Effect

    override fun processInput(input: Input) {

    }

    private fun getOnboarding() = mainRepository.getOnboarding()
        .stateOnEach { state, value -> state.copy(onboarding = value) }
        .launch()

    private fun getDarkTheme() = mainRepository.getDarkTheme()
        .stateOnEach { state, value -> state.copy(dark = value) }
        .launch()

    private fun getAppLanguage() = mainRepository.getLanguage(Language.UZ)
        .stateOnEach { state, value -> state.copy(language = value) }
        .launch()
}
