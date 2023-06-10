package com.main.notelink.features.note.edit.domain.usecase

import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.edit.fake.FakeEditNoteRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class EditNoteUseCaseTest {

    private val editNoteRepository = FakeEditNoteRepository()
    private val editNoteUseCase = EditNoteUseCase(editNoteRepository = editNoteRepository)

    @Test
    fun `test edit note`() = runBlocking {
        val testNotes = listOf(
            Note(id = 0, title = "Title", content = "Content"),
            Note(id = 1, title = "SecondTitle", content = "SecondContent"),
            Note(id = 2, title = "ThirdTitle", content = "ThirdContent")
        )
        editNoteUseCase.execute(testNotes[0])
        editNoteUseCase.execute(testNotes[1])
        editNoteUseCase.execute(testNotes[2])

        val editedFirstNote = testNotes[0].copy(title = "Edited title 1")
        editNoteUseCase.execute(editedFirstNote)

        assertEquals(editNoteRepository.notes[0], editedFirstNote.mapToNoteCache())

        val editedSecondNote = testNotes[1].copy(title = "Edited Content 2")
        editNoteUseCase.execute(editedSecondNote)

        assertEquals(editNoteRepository.notes[1], editedSecondNote.mapToNoteCache())
    }
}
