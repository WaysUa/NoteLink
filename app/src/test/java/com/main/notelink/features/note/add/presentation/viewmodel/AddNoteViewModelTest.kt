package com.main.notelink.features.note.add.presentation.viewmodel

import com.main.notelink.BaseTest
import com.main.notelink.features.note.add.data.navigation.AddNoteNavigationRepositoryImpl
import com.main.notelink.features.note.add.domain.usecase.AddNoteUseCase
import com.main.notelink.features.note.add.fake.FakeAddNoteRepository
import com.main.notelink.features.note.common.data.Note
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
            Note(title = "Title", content = "Content"),
            Note(title = "SecondTitle", content = "SecondContent"),
            Note(title = "ThirdTitle", content = "ThirdContent"),
        )
        addNoteViewModel.addNote(testNotes[0])
        addNoteViewModel.addNote(testNotes[1])

        assertEquals(testNotes[0], addNoteRepository.notes[0].mapToNote())
        assertEquals(testNotes[1], addNoteRepository.notes[1].mapToNote())

        addNoteViewModel.addNote(testNotes[2])
        assertEquals(testNotes[2], addNoteRepository.notes[2].mapToNote())
    }

    @Test
    fun `test add note, but note is empty`() {
        val testNotes = listOf(
            Note(title = "", content = ""),
            Note(title = "SecondTitle", content = "SecondContent"),
            Note(title = "ThirdTitle", content = "ThirdContent"),
        )
        addNoteViewModel.addNote(testNotes[0])
        addNoteViewModel.addNote(testNotes[1])

        assertEquals(testNotes[1], addNoteRepository.notes[0].mapToNote())
    }
}