package com.main.notelink.features.add_note.data.repository

import com.main.notelink.features.add_note.domain.repository.AddNoteRepository
import com.main.notelink.main.data.cache.entities.NoteCache

class FakeAddNoteRepository : AddNoteRepository {
    val notes = mutableListOf<NoteCache>()

    override suspend fun addNote(noteCache: NoteCache) {
        notes.add(noteCache)
    }
}