package com.main.notelink.features.notes.data.navigation

import androidx.navigation.NavController
import com.main.notelink.R
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository

class NotesNavigationRepositoryImpl : NotesNavigationRepository {

    override fun navigateToAddNoteFragment(navController: NavController) {
        navController.navigate(R.id.actionFromNotesFragmentToAddNoteFragment)
    }
}