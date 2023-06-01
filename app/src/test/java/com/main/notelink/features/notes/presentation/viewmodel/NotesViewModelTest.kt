package com.main.notelink.features.notes.presentation.viewmodel

import com.main.notelink.BaseTest
import com.main.notelink.features.notes.data.navigation.NotesNavigationRepositoryImpl
import com.main.notelink.features.notes.domain.usecase.GetNotesUseCase
import com.main.notelink.features.notes.fake.FakeGetNotesRepository
import com.main.notelink.features.notes.fake.FakeNotesCommunication
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class NotesViewModelTest : BaseTest() {

    private val getNotesRepository = FakeGetNotesRepository()
    private val getNotesUseCase = GetNotesUseCase(getNotesRepository = getNotesRepository)
    private val notesCommunication = FakeNotesCommunication()
    private val notesViewModel = NotesViewModel(
        dispatchers = FakeDispatchersList(),
        getNotesUseCase = getNotesUseCase,
        notesNavigationRepository = NotesNavigationRepositoryImpl(),
        notesCommunication = notesCommunication
    )

    @Test
    fun `test get notes`() = runBlocking {
        notesViewModel.getNotes()

        val notesResult = getNotesRepository.getNotes()

        assertEquals(notesResult[0], notesCommunication.notesList[0])
        assertEquals(notesResult[1], notesCommunication.notesList[1])
        assertEquals(notesResult[2], notesCommunication.notesList[2])
    }
}