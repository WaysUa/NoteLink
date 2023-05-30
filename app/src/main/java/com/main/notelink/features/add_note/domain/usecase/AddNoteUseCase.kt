package com.main.notelink.features.add_note.domain.usecase

import com.main.notelink.features.notes.data.entities.NoteCache
import com.main.notelink.features.add_note.domain.repository.AddNoteRepository

class AddNoteUseCase(
    private val addNoteRepository: AddNoteRepository
) {

    suspend fun addNote(noteCache: NoteCache) {
        addNoteRepository.addNote(noteCache)
    }
}