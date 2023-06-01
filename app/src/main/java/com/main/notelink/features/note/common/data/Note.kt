package com.main.notelink.features.note.common.data

import android.os.Parcelable
import com.main.notelink.main.data.cache.entities.NoteCache
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val title: String,
    val content: String
) : Parcelable {
    fun mapToNoteCache(): NoteCache {
        return NoteCache(
            title = this.title,
            content = this.content
        )
    }
}