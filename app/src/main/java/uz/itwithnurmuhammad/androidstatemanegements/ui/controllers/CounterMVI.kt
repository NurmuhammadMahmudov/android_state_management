package uz.itwithnurmuhammad.androidstatemanegements.ui.controllers

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


data class CounterState(val count: Int = 0)

sealed class CounterIntent {
    object Increment : CounterIntent()
    object Decrement : CounterIntent()
}

class CounterMVIViewModel : ViewModel() {
    private val _intent = Channel<CounterIntent>(capacity = Channel.BUFFERED)
    val intentFlow = _intent.receiveAsFlow()

    private val _state = MutableStateFlow(value = CounterState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            intentFlow.collect { intent ->
                when (intent) {
                    is CounterIntent.Increment -> _state.value = _state.value.copy(count = _state.value.count + 1)
                    is CounterIntent.Decrement -> _state.value = _state.value.copy(count = _state.value.count - 1)
                }
            }
        }
    }

    fun sendIntent(intent: CounterIntent) {
        viewModelScope.launch { _intent.send(element = intent) }
    }
}