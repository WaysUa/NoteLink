package com.main.notelink.features.note.delete.domain.usecase

import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.delete.domain.repository.DeleteNoteRepository

class DeleteNoteUseCase(
    private val deleteNoteRepository: DeleteNoteRepository
) {

    suspend fun execute(note: Note) {
        deleteNoteRepository.deleteNote(note.mapToNoteCache())
    }
}
