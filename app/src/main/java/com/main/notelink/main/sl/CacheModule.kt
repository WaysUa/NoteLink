package com.main.notelink.main.sl

import android.content.Context
import androidx.room.Room
import com.main.notelink.main.data.NoteLinkDatabase

interface CacheModule {
    fun provideDataBase(): NoteLinkDatabase

    class Base(private val context: Context): CacheModule {
        private val database by lazy {
            return@lazy Room.databaseBuilder(
                context,
                NoteLinkDatabase::class.java,
                "note_link_database"
            ).fallbackToDestructiveMigration().build()
        }

        override fun provideDataBase(): NoteLinkDatabase = database
    }

    class Mock(private val context: Context): CacheModule {
        private val database by lazy {
            Room.inMemoryDatabaseBuilder(context, NoteLinkDatabase::class.java).build()
        }

        override fun provideDataBase(): NoteLinkDatabase = database
    }
}