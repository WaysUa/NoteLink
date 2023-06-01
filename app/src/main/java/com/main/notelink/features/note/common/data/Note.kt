package com.main.notelink.features.note.common.data

import com.main.notelink.main.data.cache.entities.NoteCache

data class Note(
    val title: String,
    val content: String
) {
    fun mapToNoteCache(): NoteCache {
        return NoteCache(
            title = this.title,
            content = this.content
        )
    }
}