package com.main.notelink.main.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.main.notelink.main.data.cache.entities.NoteCache
import com.main.notelink.main.data.cache.dao.NotesDao

@Database(entities = [NoteCache::class], version = 1)
abstract class NoteLinkDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao
}