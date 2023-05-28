package com.main.feat_notes.sl

import com.main.core.sl.Module
import com.main.feat_notes.data.NotesNavigationRepositoryImpl
import com.main.feat_notes.presentation.viewmodel.NotesViewModel

class NotesModule(private val notesCore: NotesCore) : Module<NotesViewModel> {
    override fun viewModel(): NotesViewModel {
        return NotesViewModel(
            notesNavigationRepository = notesCore.provideNotesNavigation()
        )
    }
}