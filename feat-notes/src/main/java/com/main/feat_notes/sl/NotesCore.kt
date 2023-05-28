package com.main.feat_notes.sl

import com.main.feat_notes.data.NotesNavigationRepositoryImpl
import com.main.feat_notes.domain.NotesNavigationRepository

interface NotesCore : ProvideNotesNavigation {

    class Base : NotesCore {
        private val notesNavigationRepository = NotesNavigationRepositoryImpl()

        override fun provideNotesNavigation(): NotesNavigationRepository {
            return notesNavigationRepository
        }
    }
}

interface ProvideNotesNavigation {
    fun provideNotesNavigation(): NotesNavigationRepository
}