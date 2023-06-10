package com.main.notelink.features.note.delete.domain.usecase

import com.main.notelink.features.note.delete.data.entities.NoteDeleteData
import com.main.notelink.features.note.delete.fake.FakeDeleteNoteRepository
import com.main.notelink.main.data.cache.entities.NoteCache
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class DeleteNoteUseCaseTest {

    private val deleteNoteRepository = FakeDeleteNoteRepository()
    private val deleteNoteUseCase = DeleteNoteUseCase(deleteNoteRepository = deleteNoteRepository)

    @Test
    fun `test delete note`() = runBlocking {
        val notes = listOf(
            NoteDeleteData(title = "Title", content = "Content"),
            NoteDeleteData(title = "SecondTitle", content = "SecondContent"),
            NoteDeleteData(title = "ThirdTitle", content = "ThirdContent")
        )

        deleteNoteRepository.addNotes(notes.map { it.mapToNoteCache() })

        deleteNoteUseCase.execute(notes[0].mapToNote())
        deleteNoteUseCase.execute(notes[1].mapToNote())
        TestCase.assertEquals(
            notes.subList(2, notes.count()).map { it.mapToNoteCache() },
            deleteNoteRepository.list
        )

        deleteNoteUseCase.execute(notes[2].mapToNote())
        TestCase.assertEquals(emptyList<NoteCache>(), deleteNoteRepository.list)
    }
}
