package com.main.notelink.features.notes.data.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.main.notelink.R
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository

class NotesNavigationRepositoryImpl : NotesNavigationRepository {

    override fun navigateToAddNoteFragment(navController: NavController) {
        navController.navigate(R.id.actionFromNotesFragmentToAddNoteFragment)
    }

    override fun navigateToEditNoteFragment(navController: NavController, note: Note) {
        val args = bundleOf(NotesNavigationRepository.NOTE_DATA to note)
        navController.navigate(R.id.actionFromNotesFragmentToEditNoteFragment, args)
    }
}