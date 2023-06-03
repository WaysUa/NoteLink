package com.main.notelink.features.note.edit.presentation.viewmodel

import com.main.notelink.BaseTest
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.edit.data.navigation.EditNoteNavigationRepositoryImpl
import com.main.notelink.features.note.edit.domain.usecase.EditNoteUseCase
import com.main.notelink.features.note.edit.fake.FakeEditNoteRepository
import junit.framework.TestCase.assertEquals
import org.junit.Test

class EditNoteViewModelTest : BaseTest() {

    private val editNoteRepository = FakeEditNoteRepository()
    private val editNoteUseCase = EditNoteUseCase(editNoteRepository = editNoteRepository)
    private val editNoteViewModel = EditNoteViewModel(
        dispatchers = FakeDispatchersList(),
        editNoteUseCase = editNoteUseCase,
        editNoteNavigationRepository = EditNoteNavigationRepositoryImpl()
    )

    @Test
    fun `test edit note`() {
        val testNotes = listOf(
            Note(id = 0, title = "Title", content = "Content"),
            Note(id = 1, title = "SecondTitle", content = "SecondContent"),
            Note(id = 2, title = "ThirdTitle", content = "ThirdContent"),
        )
        editNoteViewModel.updateNote(testNotes[0])
        editNoteViewModel.updateNote(testNotes[1])
        editNoteViewModel.updateNote(testNotes[2])

        val editedFirstNote = testNotes[0].copy(title = "Edited title 1")
        editNoteViewModel.updateNote(editedFirstNote)

        assertEquals(editNoteRepository.notes[0], editedFirstNote.mapToNoteCache())

        val editedSecondNote = testNotes[1].copy(title = "Edited Content 2")
        editNoteViewModel.updateNote(editedSecondNote)

        assertEquals(editNoteRepository.notes[1], editedSecondNote.mapToNoteCache())
    }
}