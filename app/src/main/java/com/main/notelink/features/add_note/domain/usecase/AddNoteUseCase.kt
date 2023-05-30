package com.main.notelink.features.add_note.domain.usecase

import com.main.notelink.main.data.cache.entities.NoteCache
import com.main.notelink.features.add_note.domain.repository.AddNoteRepository

class AddNoteUseCase(
    private val addNoteRepository: AddNoteRepository
) {

    suspend fun execute(noteCache: NoteCache) {
        addNoteRepository.addNote(noteCache)
    }
}