package com.main.notelink.features.notes.domain.navigation

import androidx.navigation.NavController
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.delete.data.entities.NoteDeleteData

interface NotesNavigationRepository {

    fun navigateToAddNoteFragment(navController: NavController)

    fun navigateToEditNoteFragment(navController: NavController, note: Note)

    fun navigateToDeleteNoteFragment(navController: NavController, notes: ArrayList<NoteDeleteData>)

    companion object {
        const val NOTE_DATA = "note_data"
        const val NOTES_LIST_DATA = "notes_list_data"
    }
}
