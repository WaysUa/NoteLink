package com.main.notelink.features.notes.fake

import com.main.notelink.features.notes.domain.repository.GetNotesRepository
import com.main.notelink.main.data.cache.entities.NoteCache

class FakeGetNotesRepository : GetNotesRepository {

    override suspend fun getNotes(): List<NoteCache> {
        return listOf(
            NoteCache(title = "FirstTitle", content = "FirstContent"),
            NoteCache(title = "SecondTitle", content = "SecondContent"),
            NoteCache(title = "ThirdTitle", content = "ThirdContent"),
        )
    }
}