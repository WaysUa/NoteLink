package com.main.notelink.features.notes.data

import androidx.navigation.NavController
import com.main.core.data.NavigationDeepLink
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository

class NotesNavigationRepositoryImpl : NotesNavigationRepository {

    override fun navigateToAddNoteFragment(navController: NavController) {
        navController.navigate(NavigationDeepLink.AddNote.link)
    }
}