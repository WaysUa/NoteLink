package com.main.notelink.features.add_note.domain.repository

import com.main.notelink.features.notes.data.entities.NoteCache

interface AddNoteRepository {

    suspend fun addNote(noteCache: NoteCache)
}