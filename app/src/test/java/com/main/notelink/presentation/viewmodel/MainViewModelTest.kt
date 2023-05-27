package com.main.notelink.presentation.viewmodel

import com.main.core.presentation.NavigationStrategy
import com.main.feat_notes.data.NotesScreen
import com.main.notelink.BaseTest
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MainViewModelTest : BaseTest() {

    @Test
    fun `test navigation at start`() {
        val navigation = TestNavigationCommunication()
        val mainViewModel = MainViewModel(navigation)

        mainViewModel.init(true)
        assertEquals(1, navigation.count)
        assertEquals(NavigationStrategy.Replace(NotesScreen), navigation.strategy)

        mainViewModel.init(false)
        assertEquals(1, navigation.count)
    }
}