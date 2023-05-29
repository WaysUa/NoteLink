package com.main.notelink.features.add_note.domain.repository

import com.main.core_datasource.data.cache.NoteCache

interface AddNoteRepository {

    suspend fun addNote(noteCache: NoteCache)
}