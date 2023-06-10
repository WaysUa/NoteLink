package com.main.notelink.main.data.cache.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.main.notelink.main.data.cache.entities.NoteCache

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): List<NoteCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteCache: NoteCache)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateNote(noteCache: NoteCache)

    @Delete
    fun removeNote(noteCache: NoteCache)
}
