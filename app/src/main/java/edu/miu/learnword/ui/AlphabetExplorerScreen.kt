package edu.miu.learnword.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AlphabetExplorerScreen(
    modifier: Modifier = Modifier,
    alphabetViewModel: AlphabetViewModel = viewModel()
) {

    val alphabetUIState by alphabetViewModel.alphabetUIState.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val alphabet = alphabetUIState.currentAlphabet
        val word = alphabetUIState.currentWord
        when {
            alphabetUIState.isLoading -> {
                Text(text = "Loading...")
            }
            alphabetUIState.isError -> {
                Text(text = "Error loading alphabets")
            }
            alphabetUIState.isCompleted -> {
                Text(text = "$alphabet for $word")
            }
        }
        Button(onClick = { alphabetViewModel.nextAlphabet() }) {
            Text(text = "Next Alphabet")
        }
    }
}