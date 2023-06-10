package com.main.notelink.features.notes.fake

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.notes.presentation.communication.NotesCommunication

class FakeNotesCommunication : NotesCommunication {

    val notesList = mutableListOf<Note>()
    override fun mapNotesList(notes: List<Note>) {
        notesList.addAll(notes)
    }

    override fun observeNotesList(owner: LifecycleOwner, observer: Observer<List<Note>>) = Unit
}
