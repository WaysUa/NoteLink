package com.main.notelink.features.note.add.domain.navigation

import androidx.navigation.NavController

interface AddNoteNavigationRepository {

    fun navigateToNotesFragment(navController: NavController)
}
