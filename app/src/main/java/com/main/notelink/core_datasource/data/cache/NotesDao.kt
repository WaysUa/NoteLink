package com.main.core_datasource.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): List<NoteCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteCache: NoteCache)

}