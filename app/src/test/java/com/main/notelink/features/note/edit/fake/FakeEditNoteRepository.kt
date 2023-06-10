package com.main.notelink.features.note.edit.fake

import com.main.notelink.features.note.edit.domain.repository.EditNoteRepository
import com.main.notelink.main.data.cache.entities.NoteCache

class FakeEditNoteRepository : EditNoteRepository {
    val notes = mutableListOf<NoteCache>()

    override suspend fun editNote(note: NoteCache) {
        notes.add(note.id, note)
    }
}
