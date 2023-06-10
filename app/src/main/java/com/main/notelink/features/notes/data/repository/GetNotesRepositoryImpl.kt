package com.main.notelink.features.notes.data.repository

import com.main.notelink.features.notes.domain.repository.GetNotesRepository
import com.main.notelink.main.data.cache.dao.NotesDao
import com.main.notelink.main.data.cache.entities.NoteCache

class GetNotesRepositoryImpl(private val notesDao: NotesDao) : GetNotesRepository {

    override suspend fun getNotes(): List<NoteCache> {
        return notesDao.getAllNotes()
    }
}
