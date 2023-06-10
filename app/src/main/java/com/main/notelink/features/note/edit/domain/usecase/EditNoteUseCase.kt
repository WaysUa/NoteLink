package com.main.notelink.features.note.edit.domain.usecase

import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.edit.domain.repository.EditNoteRepository

class EditNoteUseCase(
    private val editNoteRepository: EditNoteRepository
) {

    suspend fun execute(note: Note) {
        if (note.content.isBlank() && note.title.isBlank()) return
        editNoteRepository.editNote(note.mapToNoteCache())
    }
}
