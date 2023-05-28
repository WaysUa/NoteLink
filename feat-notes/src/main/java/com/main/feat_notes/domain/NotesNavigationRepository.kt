package com.main.feat_notes.domain

import androidx.navigation.NavController

interface NotesNavigationRepository {

    fun navigateToAddNoteFragment(navController: NavController)
}