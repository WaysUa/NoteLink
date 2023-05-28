package com.main.feat_notes.sl

import com.main.core.sl.Module
import com.main.feat_notes.presentation.viewmodel.NotesViewModel

class NotesModule : Module<NotesViewModel.Base> {
    override fun viewModel(): NotesViewModel.Base {
        return NotesViewModel.Base()
    }
}