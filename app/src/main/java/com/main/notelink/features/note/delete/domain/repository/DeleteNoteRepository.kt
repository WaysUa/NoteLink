package com.main.notelink.features.note.delete.domain.repository

import com.main.notelink.main.data.cache.entities.NoteCache

interface DeleteNoteRepository {

    suspend fun deleteNote(noteCache: NoteCache)
}
