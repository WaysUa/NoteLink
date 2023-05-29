package com.main.notelink.features.notes.sl

import com.main.core_datasource.data.NoteLinkDatabase
import com.main.core_datasource.sl.CacheModule
import com.main.notelink.features.notes.data.NotesNavigationRepositoryImpl
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository

interface NotesCore : ProvideNotesNavigation, CacheModule {

    class Base(private val cacheModule: CacheModule) : NotesCore {
        private val notesNavigationRepository = NotesNavigationRepositoryImpl()


        override fun provideNotesNavigationRepository(): NotesNavigationRepository {
            return notesNavigationRepository
        }

        override fun provideDataBase(): NoteLinkDatabase {
            //todo go to core not in this file
            return cacheModule.provideDataBase()
        }
    }
}

interface ProvideNotesNavigation {
    fun provideNotesNavigationRepository(): NotesNavigationRepository
}