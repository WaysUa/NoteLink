package com.main.feat_add_note.domain

import androidx.navigation.NavController

interface AddNoteNavigationRepository {

    fun navigateToNotesFragment(navController: NavController)
}