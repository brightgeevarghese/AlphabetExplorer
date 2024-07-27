package edu.miu.learnword.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import edu.miu.learnword.data.AlphabetData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AlphabetViewModel: ViewModel() {
    // Retrieve the list of alphabet pairs from the data source
    private val alphabets = AlphabetData.alphabets
    // Initialize the MutableStateFlow with the first letter and word pair
    private val _alphabetUIState = MutableStateFlow(
        AlphabetUIState(
            currentAlphabet = alphabets[0].first,
            currentWord = alphabets[0].second,
            isLoading = false,
            isError = false,
            isCompleted = true
        )
    )
    // Expose _alphabetUIState as a read-only StateFlow to be observed by UI components
    val alphabetUIState = _alphabetUIState.asStateFlow()

    /***
     * Method to move to the next alphabet
     */
    fun nextAlphabet() {
        val currentIndex = alphabets.indexOf(
            _alphabetUIState.value.currentAlphabet to _alphabetUIState.value.currentWord
        )
        if (currentIndex < alphabets.size - 1) {
            val nextAlphabet = alphabets[currentIndex + 1]
            _alphabetUIState.value = _alphabetUIState.value.copy(
                currentAlphabet = nextAlphabet.first,
                currentWord = nextAlphabet.second,
                isLoading = false,
                isError = false,
                isCompleted = true
            )
            Log.d("AlphabetViewModel", "Next Alphabet: ${nextAlphabet.first}")
        } else if (currentIndex == alphabets.size - 1) {
            _alphabetUIState.value = _alphabetUIState.value.copy(
                currentAlphabet = alphabets[0].first,
                currentWord = alphabets[0].second
            )
        }
    }
}