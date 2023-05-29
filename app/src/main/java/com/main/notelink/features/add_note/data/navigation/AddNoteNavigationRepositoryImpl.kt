package com.main.notelink.features.add_note.data.navigation

import androidx.navigation.NavController
import com.main.notelink.features.add_note.domain.navigation.AddNoteNavigationRepository

class AddNoteNavigationRepositoryImpl : AddNoteNavigationRepository {

    override fun navigateToNotesFragment(navController: NavController) {
        navController.popBackStack()
    }
}