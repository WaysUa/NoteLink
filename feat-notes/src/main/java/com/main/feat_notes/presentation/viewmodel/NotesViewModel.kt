package com.main.feat_notes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.main.feat_notes.domain.NotesNavigationRepository

class NotesViewModel(
    private val notesNavigationRepository: NotesNavigationRepository
): ViewModel(), NotesNavigationRepository {

    override fun navigateToAddNoteFragment(navController: NavController) {
        notesNavigationRepository.navigateToAddNoteFragment(navController)
    }
}