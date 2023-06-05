package com.main.notelink.features.note.delete.data.entities

import android.os.Parcelable
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.main.data.cache.entities.NoteCache
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteDeleteData(
    val id: Int = 0,
    val title: String,
    val content: String,
    var isChecked: Boolean = false
): Parcelable {

    fun mapToNote(): Note {
        return Note(
            id = id,
            title = title,
            content = content
        )
    }

    fun mapToNoteCache(): NoteCache {
        return NoteCache(
            id = id,
            title = title,
            content = content
        )
    }
}