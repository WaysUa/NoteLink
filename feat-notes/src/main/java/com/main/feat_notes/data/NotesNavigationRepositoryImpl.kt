package com.main.feat_notes.data

import androidx.navigation.NavController
import com.main.core.data.NavigationDeepLinks
import com.main.feat_notes.domain.NotesNavigationRepository

class NotesNavigationRepositoryImpl : NotesNavigationRepository {

    override fun navigateToAddNoteFragment(navController: NavController) {
        navController.navigate(NavigationDeepLinks.ADD_NOTE_DEEP_LINK)
    }
}