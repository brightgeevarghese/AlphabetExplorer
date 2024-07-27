package edu.miu.learnword.ui

data class AlphabetUIState(
    val currentAlphabet: Char,
    val currentWord: String,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isCompleted: Boolean = false
)
