package com.main.notelink.features.note.edit.data.navigation

import androidx.navigation.NavController
import com.main.notelink.features.note.edit.domain.navigation.EditNoteNavigationRepository

class EditNoteNavigationRepositoryImpl : EditNoteNavigationRepository {

    override fun navigateToNotesFragment(navController: NavController) {
        navController.popBackStack()
    }
}
