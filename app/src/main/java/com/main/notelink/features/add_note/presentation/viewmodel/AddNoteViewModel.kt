package com.main.notelink.features.add_note.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.main.notelink.features.notes.data.entities.NoteCache
import com.main.notelink.features.add_note.domain.navigation.AddNoteNavigationRepository
import com.main.notelink.features.add_note.domain.repository.AddNoteRepository
import com.main.notelink.features.add_note.domain.usecase.AddNoteUseCase

class AddNoteViewModel(
    private val addNoteUseCase: AddNoteUseCase,
    private val addNoteNavigationRepository: AddNoteNavigationRepository
) : ViewModel(), AddNoteNavigationRepository, AddNoteRepository {

    override fun navigateToNotesFragment(navController: NavController) {
        addNoteNavigationRepository.navigateToNotesFragment(navController)
    }

    override suspend fun addNote(noteCache: NoteCache) {
        addNoteUseCase.addNote(noteCache)
    }
}