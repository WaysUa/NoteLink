package com.main.notelink.features.note.add.data.repository

import com.main.notelink.features.note.add.domain.repository.AddNoteRepository
import com.main.notelink.main.data.cache.dao.NotesDao
import com.main.notelink.main.data.cache.entities.NoteCache

class AddNoteRepositoryImpl(private val notesDao: NotesDao) : AddNoteRepository {
    override suspend fun addNote(noteCache: NoteCache) {
        notesDao.insertNote(noteCache)
    }
}