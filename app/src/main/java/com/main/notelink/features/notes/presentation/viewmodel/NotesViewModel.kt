package com.main.notelink.features.notes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository

class NotesViewModel(
    private val notesNavigationRepository: NotesNavigationRepository
): ViewModel(), NotesNavigationRepository {


    override fun navigateToAddNoteFragment(navController: NavController) {
        notesNavigationRepository.navigateToAddNoteFragment(navController)
    }
}