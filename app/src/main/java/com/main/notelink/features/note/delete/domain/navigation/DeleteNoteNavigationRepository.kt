package com.main.notelink.features.note.delete.domain.navigation

import androidx.navigation.NavController

interface DeleteNoteNavigationRepository {

    fun navigateToNotesFragment(navController: NavController)
}
