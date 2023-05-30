package com.main.notelink.features.notes.sl

import com.main.notelink.features.notes.data.repository.NotesNavigationRepositoryImpl
import com.main.notelink.main.sl.Module
import com.main.notelink.features.notes.presentation.viewmodel.NotesViewModel
import com.main.notelink.main.sl.Core

class NotesModule(private val core: Core) : Module<NotesViewModel> {
    override fun viewModel(): NotesViewModel {
        return NotesViewModel(
            notesNavigationRepository = NotesNavigationRepositoryImpl(),
        )
    }
}