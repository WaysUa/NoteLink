package com.main.notelink.features.add_note.presentation.viewmodel

import com.main.notelink.BaseTest
import com.main.notelink.features.add_note.data.navigation.AddNoteNavigationRepositoryImpl
import com.main.notelink.features.add_note.fake.FakeAddNoteRepository
import com.main.notelink.features.add_note.domain.usecase.AddNoteUseCase
import com.main.notelink.main.data.cache.entities.NoteCache
import junit.framework.TestCase.assertEquals
import org.junit.Test

class AddNoteViewModelTest : BaseTest() {

    private val addNoteRepository = FakeAddNoteRepository()
    private val addNoteUseCase = AddNoteUseCase(addNoteRepository = addNoteRepository)
    private val addNoteViewModel = AddNoteViewModel(
        dispatchers = FakeDispatchersList(),
        addNoteUseCase = addNoteUseCase,
        addNoteNavigationRepository = AddNoteNavigationRepositoryImpl()
    )

    @Test
    fun `test add note`() {
        val testNotes = listOf(
            NoteCache(title = "Title", content = "Content"),
            NoteCache(title = "SecondTitle", content = "SecondContent"),
            NoteCache(title = "ThirdTitle", content = "ThirdContent"),
        )
        addNoteViewModel.addNote(testNotes[0])
        addNoteViewModel.addNote(testNotes[1])

        assertEquals(testNotes[0], addNoteRepository.notes[0])
        assertEquals(testNotes[1], addNoteRepository.notes[1])

        addNoteViewModel.addNote(testNotes[2])
        assertEquals(testNotes[2], addNoteRepository.notes[2])
    }

    @Test
    fun `test add note, but note is empty`() {
        val testNotes = listOf(
            NoteCache(title = "", content = ""),
            NoteCache(title = "SecondTitle", content = "SecondContent"),
            NoteCache(title = "ThirdTitle", content = "ThirdContent"),
        )
        addNoteViewModel.addNote(testNotes[0])
        addNoteViewModel.addNote(testNotes[1])

        assertEquals(testNotes[1], addNoteRepository.notes[0])
    }
}