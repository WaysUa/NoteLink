package com.main.notelink.features.note.delete.data.repository

import com.main.notelink.features.note.delete.domain.repository.DeleteNoteRepository
import com.main.notelink.main.data.cache.dao.NotesDao
import com.main.notelink.main.data.cache.entities.NoteCache

class DeleteNoteRepositoryImpl(
    private val notesDao: NotesDao
) : DeleteNoteRepository {

    override suspend fun deleteNote(noteCache: NoteCache) {
        notesDao.removeNote(noteCache)
    }
}