package com.main.notelink.features.notes.presentation.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.delete.data.entities.NoteDeleteData
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository
import com.main.notelink.features.notes.domain.usecase.GetNotesUseCase
import com.main.notelink.features.notes.presentation.communication.NotesCommunication
import com.main.notelink.features.notes.presentation.communication.ObserveNotes
import com.main.notelink.main.presentation.DispatchersList
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotesViewModel(
    private val dispatchers: DispatchersList,
    private val getNotesUseCase: GetNotesUseCase,
    private val notesNavigationRepository: NotesNavigationRepository,
    private val notesCommunication: NotesCommunication
) : ViewModel(), NotesNavigationRepository, ObserveNotes {

    fun getNotes() {
        viewModelScope.launch(dispatchers.io()) {
            val notes = getNotesUseCase.execute()
            withContext(dispatchers.ui()) {
                notesCommunication.mapNotesList(notes)
            }
        }
    }

    override fun navigateToAddNoteFragment(navController: NavController) {
        notesNavigationRepository.navigateToAddNoteFragment(navController)
    }

    override fun navigateToEditNoteFragment(navController: NavController, note: Note) {
        notesNavigationRepository.navigateToEditNoteFragment(navController, note)
    }

    override fun navigateToDeleteNoteFragment(
        navController: NavController,
        notes: ArrayList<NoteDeleteData>
    ) {
        notesNavigationRepository.navigateToDeleteNoteFragment(navController, notes)
    }

    override fun observeNotesList(owner: LifecycleOwner, observer: Observer<List<Note>>) {
        notesCommunication.observeNotesList(owner, observer)
    }
}
