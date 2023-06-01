package com.main.notelink.features.notes.presentation.communication

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.main.presentation.Communication

interface NotesCommunication : ObserveNotes {

    fun mapNotesList(notes: List<Note>)

    class Base(
        private val notesListCommunication: NotesListCommunication
    ) : NotesCommunication {

        override fun mapNotesList(notes: List<Note>) {
            notesListCommunication.map(notes)
        }

        override fun observeNotesList(owner: LifecycleOwner, observer: Observer<List<Note>>) {
            notesListCommunication.observe(owner, observer)
        }
    }
}

interface ObserveNotes {

    fun observeNotesList(owner: LifecycleOwner, observer: Observer<List<Note>>)
}

interface NotesListCommunication : Communication.Mutable<List<Note>> {
    class Base : Communication.Ui<List<Note>>(), NotesListCommunication
}