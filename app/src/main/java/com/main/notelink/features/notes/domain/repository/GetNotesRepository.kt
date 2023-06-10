package com.main.notelink.features.notes.domain.repository

import com.main.notelink.main.data.cache.entities.NoteCache

interface GetNotesRepository {

    suspend fun getNotes(): List<NoteCache>
}
