package com.main.notelink.features.add_note.data.repository

import com.main.notelink.features.notes.data.entities.NoteCache
import com.main.notelink.features.notes.domain.cache.NotesDao
import com.main.notelink.features.add_note.domain.repository.AddNoteRepository

class AddNoteRepositoryImpl(private val notesDao: NotesDao) : AddNoteRepository {
    override suspend fun addNote(noteCache: NoteCache) {
        notesDao.insertNote(noteCache)
    }
}