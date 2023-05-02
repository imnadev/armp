package io.ansor.al.huda.common.architecture

import io.ansor.al.huda.domain.model.ErrorEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Store<State, Input, Effect> {

    val state: StateFlow<State>

    val effects: Flow<Effect>

    fun processInput(input: Input)

    val errors: Flow<ErrorEntity>
}
