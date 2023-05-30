package com.main.notelink.main.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.main.notelink.features.notes.data.entities.NoteCache
import com.main.notelink.features.notes.domain.cache.NotesDao

@Database(entities = [NoteCache::class], version = 1)
abstract class NoteLinkDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao
}