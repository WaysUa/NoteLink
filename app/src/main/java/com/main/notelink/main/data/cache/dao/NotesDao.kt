package com.main.notelink.main.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.main.notelink.main.data.cache.entities.NoteCache

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): List<NoteCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteCache: NoteCache)

}