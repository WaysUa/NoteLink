package com.main.notelink.features.notes.sl

import com.main.core.sl.Module
import com.main.notelink.features.notes.presentation.viewmodel.NotesViewModel

class NotesModule(private val notesCore: NotesCore) : Module<NotesViewModel> {
    override fun viewModel(): NotesViewModel {
        return NotesViewModel(
            dao = notesCore.provideDataBase().notesDao(),
            notesNavigationRepository = notesCore.provideNotesNavigationRepository(),
        )
    }
}