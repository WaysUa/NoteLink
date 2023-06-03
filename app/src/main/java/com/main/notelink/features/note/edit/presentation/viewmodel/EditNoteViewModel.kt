package com.main.notelink.features.note.edit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.edit.domain.navigation.EditNoteNavigationRepository
import com.main.notelink.features.note.edit.domain.usecase.EditNoteUseCase
import com.main.notelink.main.presentation.DispatchersList
import kotlinx.coroutines.launch

class EditNoteViewModel(
    private val dispatchers: DispatchersList,
    private val editNoteUseCase: EditNoteUseCase,
    private val editNoteNavigationRepository: EditNoteNavigationRepository
) : ViewModel(), EditNoteNavigationRepository {

    fun updateNote(note: Note) {
        viewModelScope.launch(dispatchers.io()) {
            editNoteUseCase.execute(note)
        }
    }

    override fun navigateToNotesFragment(navController: NavController) {
        editNoteNavigationRepository.navigateToNotesFragment(navController)
    }
}