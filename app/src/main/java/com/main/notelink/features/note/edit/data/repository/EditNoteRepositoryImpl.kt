package com.main.notelink.features.note.edit.data.repository

import com.main.notelink.features.note.edit.domain.repository.EditNoteRepository
import com.main.notelink.main.data.cache.dao.NotesDao
import com.main.notelink.main.data.cache.entities.NoteCache

class EditNoteRepositoryImpl(private val notesDao: NotesDao) : EditNoteRepository {

    override suspend fun editNote(note: NoteCache) {
        notesDao.updateNote(note)
    }
}