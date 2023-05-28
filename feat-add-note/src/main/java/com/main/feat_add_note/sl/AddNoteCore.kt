package com.main.feat_add_note.sl

import com.main.feat_add_note.data.AddNoteNavigationRepositoryImpl
import com.main.feat_add_note.domain.AddNoteNavigationRepository

interface AddNoteCore : ProvideNotesNavigation {

    class Base : AddNoteCore {
        private val addNoteNavigationRepository = AddNoteNavigationRepositoryImpl()

        override fun provideAddNoteNavigationRepository(): AddNoteNavigationRepository {
            return addNoteNavigationRepository
        }
    }
}

interface ProvideNotesNavigation {
    fun provideAddNoteNavigationRepository(): AddNoteNavigationRepository
}