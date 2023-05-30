package com.main.notelink.features.notes.sl

import com.main.notelink.features.notes.data.navigation.NotesNavigationRepositoryImpl
import com.main.notelink.features.notes.data.repository.GetNotesRepositoryImpl
import com.main.notelink.features.notes.domain.usecase.GetNotesUseCase
import com.main.notelink.main.sl.Module
import com.main.notelink.features.notes.presentation.viewmodel.NotesViewModel
import com.main.notelink.main.sl.Core

class NotesModule(private val core: Core) : Module<NotesViewModel> {
    override fun viewModel(): NotesViewModel {
        return NotesViewModel(
            getNotesUseCase = GetNotesUseCase(
                GetNotesRepositoryImpl(core.provideDataBase().notesDao())
            ),
            notesNavigationRepository = NotesNavigationRepositoryImpl(),
        )
    }
}