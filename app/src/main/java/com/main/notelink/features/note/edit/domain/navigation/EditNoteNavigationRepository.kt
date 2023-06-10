package com.main.notelink.features.note.edit.domain.navigation

import androidx.navigation.NavController

interface EditNoteNavigationRepository {

    fun navigateToNotesFragment(navController: NavController)
}
