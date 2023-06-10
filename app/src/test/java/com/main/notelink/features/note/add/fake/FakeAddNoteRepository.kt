package com.main.notelink.features.note.add.fake

import com.main.notelink.features.note.add.domain.repository.AddNoteRepository
import com.main.notelink.main.data.cache.entities.NoteCache

class FakeAddNoteRepository : AddNoteRepository {
    val notes = mutableListOf<NoteCache>()

    override suspend fun addNote(noteCache: NoteCache) {
        notes.add(noteCache)
    }
}
