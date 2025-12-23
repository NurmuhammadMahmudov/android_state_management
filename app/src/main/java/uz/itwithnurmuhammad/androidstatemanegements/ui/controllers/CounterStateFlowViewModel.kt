package uz.itwithnurmuhammad.androidstatemanegements.ui.controllers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CounterStateFlowViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    fun increment() {
        viewModelScope.launch {
            _count.value += 1
        }
    }

    fun decrement() {
        viewModelScope.launch {
            _count.value -= 1
        }
    }
}