package com.main.notelink.features.note.edit.domain.repository

import com.main.notelink.main.data.cache.entities.NoteCache

interface EditNoteRepository {

    suspend fun editNote(note: NoteCache)
}
