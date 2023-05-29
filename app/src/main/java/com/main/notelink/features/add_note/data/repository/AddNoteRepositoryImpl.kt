package com.main.notelink.features.add_note.data.repository

import com.main.core_datasource.data.cache.NoteCache
import com.main.core_datasource.data.cache.NotesDao
import com.main.notelink.features.add_note.domain.repository.AddNoteRepository

class AddNoteRepositoryImpl(private val notesDao: NotesDao) : AddNoteRepository {
    override suspend fun addNote(noteCache: NoteCache) {
        notesDao.insertNote(noteCache)
    }
}