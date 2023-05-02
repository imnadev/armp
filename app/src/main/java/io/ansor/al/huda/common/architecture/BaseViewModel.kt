package io.ansor.al.huda.common.architecture

import android.os.Looper
import androidx.annotation.MainThread
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ansor.al.huda.domain.model.ErrorEntity
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.*
import timber.log.Timber

abstract class BaseViewModel<State : Any, Input : Any, Effect : Any>(initialState: State) :
    Store<State, Input, Effect>, ViewModel() {

    private val effectsChannel = Channel<Effect>(Channel.BUFFERED)

    private val errorsChannel = Channel<ErrorEntity>(Channel.BUFFERED)

    override val errors: Flow<ErrorEntity>
        get() = errorsChannel.receiveAsFlow()

    private val _state by lazy(LazyThreadSafetyMode.NONE) {
        MutableStateFlow(initialState)
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected val log: Timber.Tree
        get() = Timber.tag(tag)

    protected open val tag: String = "MVI:${javaClass.simpleName}"

    override val state: StateFlow<State>
        get() = _state

    override val effects: Flow<Effect>
        get() = effectsChannel.receiveAsFlow()

    init {
        log.v("View model created")
    }

    override fun onCleared() {
        log.v("View model destroyed")
        super.onCleared()
    }

    protected fun getState(): State = _state.value

    fun emitEffect(effect: Effect) {
        val result = effectsChannel.trySendBlocking(effect)
        log.v("Dispatching effect: %s", effect)
        if (!result.isSuccess) {
            log.w("Failed to dispatch effect: %s", result)
        }
    }

    @MainThread
    protected fun emitState(state: State): State {
        require(Looper.getMainLooper() == Looper.myLooper()) {
            "Must be running on main thread"
        }

        _state.value = state

        return _state.value
    }

    @MainThread
    fun updateState(update: (state: State) -> State): State {
        val newState = update(getState())
        return emitState(newState)
    }

    protected inline fun <reified T : State> requireState() = getState() as T

    protected fun <T> Flow<T>.stateOnStart(action: (state: State) -> State) = onStart {
        updateState { action(it) }
    }

    protected fun <T> Flow<T>.stateOnComplete(action: (state: State) -> State) = onCompletion {
        updateState { action(it) }
    }

    protected fun <T> Flow<T>.stateOnEach(action: (state: State, value: T) -> State) =
        onEach { value ->
            updateState { action(it, value) }
        }

    protected fun <T> Flow<T>.effectOnCatch(action: (e: ErrorEntity) -> Effect) = catch {
        emitEffect(action(it as? ErrorEntity ?: ErrorEntity.Unknown))
        throw it
    }

    protected fun <T> Flow<T>.effectOnEach(action: (value: T) -> Effect) = onEach {
        emitEffect(action(it))
    }

    protected fun <T> Flow<T>.stateOnCatch(action: (state: State, e: ErrorEntity) -> State) =
        catch {
            updateState { state -> action(state, it as? ErrorEntity ?: ErrorEntity.Unknown) }
            throw it
        }

    protected fun <T> Flow<T>.launch() = catch {
        errorsChannel.send(it as? ErrorEntity ?: ErrorEntity.Unknown)
    }.launchIn(viewModelScope)
}