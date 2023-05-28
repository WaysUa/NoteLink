package com.main.feat_add_note.data

import androidx.navigation.NavController
import com.main.feat_add_note.domain.AddNoteNavigationRepository

class AddNoteNavigationRepositoryImpl : AddNoteNavigationRepository {

    override fun navigateToNotesFragment(navController: NavController) {
        navController.popBackStack()
    }
}