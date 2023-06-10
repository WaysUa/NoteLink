package com.main.notelink.features.note.add.domain.usecase

import com.main.notelink.features.note.add.domain.repository.AddNoteRepository
import com.main.notelink.features.note.common.data.Note

class AddNoteUseCase(
    private val addNoteRepository: AddNoteRepository
) {

    suspend fun execute(note: Note) {
        if (note.content.isBlank() && note.title.isBlank()) return
        addNoteRepository.addNote(note.mapToNoteCache())
    }
}
