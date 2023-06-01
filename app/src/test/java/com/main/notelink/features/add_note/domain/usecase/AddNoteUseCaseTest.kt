package com.main.notelink.features.add_note.domain.usecase

import com.main.notelink.features.add_note.data.repository.FakeAddNoteRepository
import com.main.notelink.main.data.cache.entities.NoteCache
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class AddNoteUseCaseTest {

    private val addNoteRepository = FakeAddNoteRepository()
    private val addNoteUseCase = AddNoteUseCase(addNoteRepository)

    @Test
    fun `test add note`() = runBlocking {
        val testNotes = listOf(
            NoteCache(title = "Title", content = "Content"),
            NoteCache(title = "SecondTitle", content = "SecondContent"),
            NoteCache(title = "ThirdTitle", content = "ThirdContent"),
        )
        addNoteUseCase.execute(testNotes[0])
        addNoteUseCase.execute(testNotes[1])

        assertEquals(testNotes[0], addNoteRepository.notes[0])
        assertEquals(testNotes[1], addNoteRepository.notes[1])

        addNoteUseCase.execute(testNotes[2])
        assertEquals(testNotes[2], addNoteRepository.notes[2])
    }
}