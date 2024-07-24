package edu.miu.worddemo.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel: ViewModel() {
    // MutableStateFlow to hold the UI state. Initial state is CountUIState with default values.
    private val _uiState = MutableStateFlow(CountUIState())
    // Expose _uiState as a read-only StateFlow to be observed by UI components.
    val count = _uiState.asStateFlow()

    fun increment() {
        // Update the current state by creating a new instance with an incremented count.
        _uiState.value = _uiState.value.copy(count = _uiState.value.count + 1)
        // Log the current state for debugging purposes.
        Log.d("CounterViewModel", "${_uiState.value}") //UIState(count=1)
    }

}