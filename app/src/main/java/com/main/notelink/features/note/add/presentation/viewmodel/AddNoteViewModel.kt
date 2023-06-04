package com.main.notelink.features.note.add.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.main.notelink.features.note.add.domain.navigation.AddNoteNavigationRepository
import com.main.notelink.features.note.add.domain.usecase.AddNoteUseCase
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.main.presentation.DispatchersList
import kotlinx.coroutines.launch

class AddNoteViewModel(
    private val dispatchers: DispatchersList,
    private val addNoteUseCase: AddNoteUseCase,
    private val addNoteNavigationRepository: AddNoteNavigationRepository
) : ViewModel(), AddNoteNavigationRepository {

    fun addNote(note: Note) {
        viewModelScope.launch(dispatchers.io()) {
            addNoteUseCase.execute(note)
        }
    }

    override fun navigateToNotesFragment(navController: NavController) {
        addNoteNavigationRepository.navigateToNotesFragment(navController)
    }
}