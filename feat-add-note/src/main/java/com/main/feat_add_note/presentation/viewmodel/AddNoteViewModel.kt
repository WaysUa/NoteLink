package com.main.feat_add_note.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.main.feat_add_note.domain.AddNoteNavigationRepository

class AddNoteViewModel(
    private val addNoteNavigationRepository: AddNoteNavigationRepository
) : ViewModel(), AddNoteNavigationRepository {

    override fun navigateToNotesFragment(navController: NavController) {
        addNoteNavigationRepository.navigateToNotesFragment(navController)
    }
}