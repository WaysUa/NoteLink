package com.main.notelink.features.notes.fake

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.notelink.features.notes.presentation.communication.NotesCommunication
import com.main.notelink.main.data.cache.entities.NoteCache

class FakeNotesCommunication : NotesCommunication {

    val notesList = mutableListOf<NoteCache>()

    override fun mapNotesList(notes: List<NoteCache>) {
        notesList.addAll(notes)
    }

    override fun observeNotesList(owner: LifecycleOwner, observer: Observer<List<NoteCache>>) = Unit
}