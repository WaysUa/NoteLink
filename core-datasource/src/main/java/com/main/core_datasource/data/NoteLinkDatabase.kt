package com.main.core_datasource.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.main.core_datasource.data.cache.NoteCache
import com.main.core_datasource.data.cache.NotesDao

@Database(entities = [NoteCache::class], version = 1)
abstract class NoteLinkDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao
}