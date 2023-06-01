package com.main.notelink.features.notes.domain

import com.main.notelink.features.notes.domain.usecase.GetNotesUseCase
import com.main.notelink.features.notes.fake.FakeGetNotesRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetNotesUseCaseTest {

    private val getNotesRepository = FakeGetNotesRepository()
    private val getNotesUseCase = GetNotesUseCase(getNotesRepository)

    @Test
    fun `test get notes`() = runBlocking {
        val notesResult = getNotesUseCase.execute()

        assertEquals(notesResult[0], getNotesRepository.getNotes()[0])
        assertEquals(notesResult[1], getNotesRepository.getNotes()[1])
        assertEquals(notesResult[2], getNotesRepository.getNotes()[2])
    }
}