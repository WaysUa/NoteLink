package com.main.notelink.features.note.add.domain.usecase

import com.main.notelink.features.note.add.fake.FakeAddNoteRepository
import com.main.notelink.features.note.common.data.Note
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class AddNoteUseCaseTest {

    private val addNoteRepository = FakeAddNoteRepository()
    private val addNoteUseCase = AddNoteUseCase(addNoteRepository)

    @Test
    fun `test add note`() = runBlocking {
        val testNotes = listOf(
            Note(title = "Title", content = "Content"),
            Note(title = "SecondTitle", content = "SecondContent"),
            Note(title = "ThirdTitle", content = "ThirdContent"),
        )
        addNoteUseCase.execute(testNotes[0])
        addNoteUseCase.execute(testNotes[1])

        assertEquals(testNotes[0], addNoteRepository.notes[0].mapToNote())
        assertEquals(testNotes[1], addNoteRepository.notes[1].mapToNote())

        addNoteUseCase.execute(testNotes[2])
        assertEquals(testNotes[2], addNoteRepository.notes[2].mapToNote())
    }
}