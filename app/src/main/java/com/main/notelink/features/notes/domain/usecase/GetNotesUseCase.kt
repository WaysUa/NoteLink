package com.main.notelink.features.notes.domain.usecase

import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.notes.domain.repository.GetNotesRepository

class GetNotesUseCase(
    private val getNotesRepository: GetNotesRepository
) {

    suspend fun execute(): List<Note> {
        return getNotesRepository.getNotes().map { it.mapToNote() }
    }
}
