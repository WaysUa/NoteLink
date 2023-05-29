package com.main.notelink.features.add_note.sl

import com.main.core.sl.Module
import com.main.notelink.features.add_note.presentation.viewmodel.AddNoteViewModel

class AddNoteModule(private val addNoteCore: AddNoteCore) : Module<AddNoteViewModel> {
    override fun viewModel(): AddNoteViewModel {
        return AddNoteViewModel(
            addNoteNavigationRepository = addNoteCore.provideAddNoteNavigationRepository(),
            addNoteUseCase = addNoteCore.provideAddNoteUseCase()
        )
    }
}