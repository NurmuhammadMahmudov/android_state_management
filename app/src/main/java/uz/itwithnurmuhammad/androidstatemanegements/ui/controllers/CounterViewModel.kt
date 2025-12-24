package uz.itwithnurmuhammad.androidstatemanegements.ui.controllers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var count by mutableIntStateOf(value = 0)
        private set

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }
}