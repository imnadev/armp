package io.ansor.al.huda.presentation.language

import dagger.hilt.android.lifecycle.HiltViewModel
import io.ansor.al.huda.common.architecture.BaseViewModel
import io.ansor.al.huda.domain.model.Language
import io.ansor.al.huda.domain.repo.MainRepository
import io.ansor.al.huda.presentation.language.LanguageViewModel.*
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel<State, Input, Effect>(State()) {

    init {
        getAppLanguage()
    }

    data class State(
        val appLanguage: Language = Language.UZ
    )

    sealed class Input {
        data class SetLanguage(val language: Language) : Input()
        data class SetOnboarding(val show: Boolean) : Input()
    }

    class Effect

    override fun processInput(input: Input) {
        when (input) {
            is Input.SetLanguage -> setLanguage(input.language)
            is Input.SetOnboarding -> setOnboarding(input.show)
        }
    }

    private fun getAppLanguage() = mainRepository.getLanguage(Language.UZ)
        .stateOnEach { state, value -> state.copy(appLanguage = value) }.launch()

    private fun setLanguage(language: Language) = mainRepository.setLanguage(language).launch()

    private fun setOnboarding(show: Boolean) = mainRepository.setOnboarding(show).launch()
}