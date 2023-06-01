package com.main.notelink.features.note.add.data.navigation

import androidx.navigation.NavController
import com.main.notelink.features.note.add.domain.navigation.AddNoteNavigationRepository

class AddNoteNavigationRepositoryImpl : AddNoteNavigationRepository {

    override fun navigateToNotesFragment(navController: NavController) {
        navController.popBackStack()
    }
}