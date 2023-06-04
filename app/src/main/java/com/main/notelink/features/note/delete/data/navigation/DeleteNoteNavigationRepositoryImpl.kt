package com.main.notelink.features.note.delete.data.navigation

import androidx.navigation.NavController
import com.main.notelink.features.note.delete.domain.navigation.DeleteNoteNavigationRepository

class DeleteNoteNavigationRepositoryImpl : DeleteNoteNavigationRepository {

    override fun navigateToNotesFragment(navController: NavController) {
        navController.popBackStack()
    }
}