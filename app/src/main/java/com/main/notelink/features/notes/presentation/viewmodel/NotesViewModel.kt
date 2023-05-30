package com.main.notelink.features.notes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository
import com.main.notelink.features.notes.domain.repository.GetNotesRepository
import com.main.notelink.features.notes.domain.usecase.GetNotesUseCase
import com.main.notelink.main.data.cache.entities.NoteCache

class NotesViewModel(
    private val getNotesUseCase: GetNotesUseCase,
    private val notesNavigationRepository: NotesNavigationRepository
): ViewModel(), NotesNavigationRepository, GetNotesRepository {


    override fun navigateToAddNoteFragment(navController: NavController) {
        notesNavigationRepository.navigateToAddNoteFragment(navController)
    }

    override suspend fun getNotes(): List<NoteCache> {
        return getNotesUseCase.execute()
    }
}