package com.main.notelink.features.note.delete.fake

import com.main.notelink.features.note.delete.domain.repository.DeleteNoteRepository
import com.main.notelink.main.data.cache.entities.NoteCache

class FakeDeleteNoteRepository : DeleteNoteRepository {

    val list = mutableListOf<NoteCache>()

    fun addNotes(notes: List<NoteCache>) {
        list.addAll(notes)
    }

    override suspend fun deleteNote(noteCache: NoteCache) {
        list.remove(noteCache)
    }
}