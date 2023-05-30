package com.main.notelink.features.notes.presentation.communication

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.notelink.main.data.cache.entities.NoteCache
import com.main.notelink.main.presentation.Communication

interface NotesCommunication : ObserveNotes {

    fun mapNotesList(notes: List<NoteCache>)

    class Base(
        private val notesListCommunication: NotesListCommunication
    ) : NotesCommunication {

        override fun mapNotesList(notes: List<NoteCache>) {
            notesListCommunication.map(notes)
        }

        override fun observeNotesList(owner: LifecycleOwner, observer: Observer<List<NoteCache>>) {
            notesListCommunication.observe(owner, observer)
        }
    }
}

interface ObserveNotes {

    fun observeNotesList(owner: LifecycleOwner, observer: Observer<List<NoteCache>>)
}

interface NotesListCommunication : Communication.Mutable<List<NoteCache>> {
    class Base : Communication.Ui<List<NoteCache>>(), NotesListCommunication
}