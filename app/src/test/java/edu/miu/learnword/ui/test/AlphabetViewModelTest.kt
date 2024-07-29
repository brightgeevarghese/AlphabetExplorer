package edu.miu.learnword.ui.test

import edu.miu.learnword.ui.AlphabetViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class AlphabetViewModelTest {
    private var viewModel: AlphabetViewModel? = null

    @Before
    fun setup() {
        viewModel = AlphabetViewModel()
    }

    @Test
    fun testInitialState() {
        // Retrieve the initial state
        val initialState = viewModel!!.alphabetUIState.value
        assertEquals("Initial alphabet should be A", 'A', initialState.currentAlphabet)
        assertEquals("Initial word should be Apple", "Apple", initialState.currentWord)
        assertEquals("Initial isLoading should be false", false, initialState.isLoading)
        assertEquals("Initial isError should be false", false, initialState.isError)
        assertEquals("Initial isCompleted should be true", true, initialState.isCompleted)
    }
    @Test
    fun testNextAlphabetAfterInitialState() {
        // Call nextAlphabet after the initial state
        viewModel?.nextAlphabet()
        val nextState = viewModel!!.alphabetUIState.value
        assertEquals("Next alphabet should be B", 'B', nextState.currentAlphabet)
        assertEquals("Next word should be Ball", "Ball", nextState.currentWord)
        assertEquals("Next isLoading should be false", false, nextState.isLoading)
        assertEquals("Next isError should be false", false, nextState.isError)
        assertEquals("Next isCompleted should be true", true, nextState.isCompleted)
    }

    @Test
    fun testNextAlphabet_LastAlphabet() {
        // Cycle through all 25 alphabets by calling nextAlphabet 25 times
        repeat(25) {
            viewModel?.nextAlphabet()
        }
        val finalState = viewModel!!.alphabetUIState.value
        assertEquals("Final alphabet should be Z", 'Z', finalState.currentAlphabet)
        assertEquals("Final word should be Zebra", "Zebra", finalState.currentWord)
        assertEquals("Final isLoading should be false", false, finalState.isLoading)
        assertEquals("Final isError should be false", false, finalState.isError)
        assertEquals("Final isCompleted should be true", true, finalState.isCompleted)
    }

    @Test
    fun testCycleThroughAlphabets() {
        // Cycle through all 26 alphabets by calling nextAlphabet 26 times
        repeat(26) {
            viewModel?.nextAlphabet()
        }
        // Retrieve the state after cycling through all alphabets
        val finalState = viewModel!!.alphabetUIState.value
        assertEquals("Alphabet should cycle back to 'A'", 'A', finalState.currentAlphabet)
        assertEquals("Word should cycle back to 'Apple'", "Apple", finalState.currentWord)
        assertEquals("isLoading should be false", false, finalState.isLoading)
        assertEquals("isError should be false", false, finalState.isError)
        assertEquals("isCompleted should be true", true, finalState.isCompleted)
    }

    @After
    fun tearDown() {
        // Clean up resources if needed
        viewModel = null
    }

}