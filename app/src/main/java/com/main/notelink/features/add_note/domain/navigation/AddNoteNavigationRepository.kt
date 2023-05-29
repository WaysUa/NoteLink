package com.main.notelink.features.add_note.domain.navigation

import androidx.navigation.NavController

interface AddNoteNavigationRepository {

    fun navigateToNotesFragment(navController: NavController)
}