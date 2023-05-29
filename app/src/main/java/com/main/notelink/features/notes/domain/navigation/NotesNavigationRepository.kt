package com.main.notelink.features.notes.domain.navigation

import androidx.navigation.NavController

interface NotesNavigationRepository {

    fun navigateToAddNoteFragment(navController: NavController)
}