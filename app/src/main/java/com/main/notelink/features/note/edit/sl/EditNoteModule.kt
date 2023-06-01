package com.main.notelink.features.note.edit.sl

import com.main.notelink.core.sl.Module
import com.main.notelink.features.note.edit.presentation.viewmodel.EditNoteViewModel

class EditNoteModule : Module<EditNoteViewModel> {
    override fun viewModel(): EditNoteViewModel {
        return EditNoteViewModel()
    }
}