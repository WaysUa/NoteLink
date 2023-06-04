package com.main.notelink.features.note.delete.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.main.notelink.features.note.delete.domain.navigation.DeleteNoteNavigationRepository

class DeleteNoteViewModel(
    private val deleteNoteNavigationRepository: DeleteNoteNavigationRepository
) : ViewModel(), DeleteNoteNavigationRepository {

    override fun navigateToNotesFragment(navController: NavController) {
        deleteNoteNavigationRepository.navigateToNotesFragment(navController)
    }
}