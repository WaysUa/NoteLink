package com.main.notelink.features.note.delete.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.main.notelink.features.note.delete.data.entities.NoteDeleteData
import com.main.notelink.features.note.delete.domain.navigation.DeleteNoteNavigationRepository
import com.main.notelink.features.note.delete.domain.usecase.DeleteNoteUseCase
import com.main.notelink.main.presentation.DispatchersList
import kotlinx.coroutines.launch

class DeleteNoteViewModel(
    private val dispatchers: DispatchersList,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val deleteNoteNavigationRepository: DeleteNoteNavigationRepository
) : ViewModel(), DeleteNoteNavigationRepository {

    fun deleteNote(noteDeleteData: NoteDeleteData) {
        viewModelScope.launch(dispatchers.io()) {
            deleteNoteUseCase.execute(noteDeleteData.mapToNote())
        }
    }

    override fun navigateToNotesFragment(navController: NavController) {
        deleteNoteNavigationRepository.navigateToNotesFragment(navController)
    }
}
