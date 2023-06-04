package com.main.notelink.features.notes.domain.navigation

import androidx.navigation.NavController
import com.main.notelink.features.note.common.data.Note

interface NotesNavigationRepository {

    fun navigateToAddNoteFragment(navController: NavController)

    fun navigateToEditNoteFragment(navController: NavController, note: Note)

    fun navigateToDeleteNoteFragment(navController: NavController, note: Note)

    companion object {
        const val NOTE_DATA = "note_data"
    }
}