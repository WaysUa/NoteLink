package com.main.notelink.main.data.cache.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.main.notelink.features.note.common.data.Note

@Entity(tableName = "notes_table")
data class NoteCache(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String
) {
    fun mapToNote(): Note {
        return Note(
            id = id,
            title = title,
            content = content
        )
    }
}
