package com.main.notelink.features.note.common.data

import android.os.Parcelable
import com.main.notelink.features.note.delete.data.entities.NoteDeleteData
import com.main.notelink.main.data.cache.entities.NoteCache
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val id: Int = 0,
    val title: String,
    val content: String
) : Parcelable {
    fun mapToNoteCache(): NoteCache {
        return NoteCache(
            id = id,
            title = title,
            content = content
        )
    }

    fun mapToNoteDeleteData(): NoteDeleteData {
        return NoteDeleteData(
            id = id,
            title = title,
            content = content
        )
    }
}