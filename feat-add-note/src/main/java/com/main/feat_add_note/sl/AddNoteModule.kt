package com.main.feat_add_note.sl

import com.main.core.sl.Module
import com.main.feat_add_note.presentation.viewmodel.AddNoteViewModel

class AddNoteModule(private val addNoteCore: AddNoteCore) : Module<AddNoteViewModel> {
    override fun viewModel(): AddNoteViewModel {
        return AddNoteViewModel(
            addNoteNavigationRepository = addNoteCore.provideAddNoteNavigationRepository()
        )
    }
}