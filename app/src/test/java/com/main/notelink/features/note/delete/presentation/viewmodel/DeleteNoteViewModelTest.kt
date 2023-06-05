package com.main.notelink.features.note.delete.presentation.viewmodel

import com.main.notelink.BaseTest
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.delete.data.entities.NoteDeleteData
import com.main.notelink.features.note.delete.data.navigation.DeleteNoteNavigationRepositoryImpl
import com.main.notelink.features.note.delete.domain.repository.DeleteNoteRepository
import com.main.notelink.features.note.delete.domain.usecase.DeleteNoteUseCase
import com.main.notelink.features.note.delete.fake.FakeDeleteNoteRepository
import com.main.notelink.main.data.cache.entities.NoteCache
import junit.framework.TestCase.assertEquals
import org.junit.Test

class DeleteNoteViewModelTest : BaseTest() {

    private val deleteNoteRepository = FakeDeleteNoteRepository()
    private val deleteNoteUseCase = DeleteNoteUseCase(deleteNoteRepository = deleteNoteRepository)
    private val deleteNoteViewModel = DeleteNoteViewModel(
        dispatchers = FakeDispatchersList(),
        deleteNoteUseCase = deleteNoteUseCase,
        deleteNoteNavigationRepository = DeleteNoteNavigationRepositoryImpl()
    )

    @Test
    fun `test delete note`() {
        val notes = listOf(
            NoteDeleteData(title = "Title", content = "Content"),
            NoteDeleteData(title = "SecondTitle", content = "SecondContent"),
            NoteDeleteData(title = "ThirdTitle", content = "ThirdContent"),
        )

        deleteNoteRepository.addNotes(notes.map { it.mapToNoteCache() })

        deleteNoteViewModel.deleteNote(notes[0])
        deleteNoteViewModel.deleteNote(notes[1])
        assertEquals(notes.subList(2, notes.count()).map { it.mapToNoteCache() }, deleteNoteRepository.list)

        deleteNoteViewModel.deleteNote(notes[2])
        assertEquals(emptyList<NoteCache>(), deleteNoteRepository.list)
    }
}