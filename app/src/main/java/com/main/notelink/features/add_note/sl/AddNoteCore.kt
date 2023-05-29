package com.main.notelink.features.add_note.sl

import com.main.core_datasource.data.NoteLinkDatabase
import com.main.core_datasource.sl.CacheModule
import com.main.notelink.features.add_note.data.navigation.AddNoteNavigationRepositoryImpl
import com.main.notelink.features.add_note.data.repository.AddNoteRepositoryImpl
import com.main.notelink.features.add_note.domain.navigation.AddNoteNavigationRepository
import com.main.notelink.features.add_note.domain.usecase.AddNoteUseCase

interface AddNoteCore : ProvideNotesNavigation, ProvideAddNoteUseCase, CacheModule {

    class Base(private val cacheModule: CacheModule) : AddNoteCore {
        private val addNoteRepository = AddNoteRepositoryImpl(provideDataBase().notesDao())
        private val addNoteNavigationRepository = AddNoteNavigationRepositoryImpl()
        private val addNoteUseCase = AddNoteUseCase(addNoteRepository)

        override fun provideAddNoteNavigationRepository(): AddNoteNavigationRepository {
            return addNoteNavigationRepository
        }

        override fun provideAddNoteUseCase(): AddNoteUseCase {
            return addNoteUseCase
        }

        override fun provideDataBase(): NoteLinkDatabase {
            return cacheModule.provideDataBase()
        }
    }
}

interface ProvideNotesNavigation {
    fun provideAddNoteNavigationRepository(): AddNoteNavigationRepository
}

interface ProvideAddNoteUseCase {
    fun provideAddNoteUseCase(): AddNoteUseCase
}