package com.main.notelink.features.add_note.sl

import com.main.notelink.features.add_note.data.navigation.AddNoteNavigationRepositoryImpl
import com.main.notelink.features.add_note.data.repository.AddNoteRepositoryImpl
import com.main.notelink.features.add_note.domain.usecase.AddNoteUseCase
import com.main.notelink.main.sl.Module
import com.main.notelink.features.add_note.presentation.viewmodel.AddNoteViewModel
import com.main.notelink.main.sl.Core

class AddNoteModule(private val core: Core) : Module<AddNoteViewModel> {
    override fun viewModel(): AddNoteViewModel {
        return AddNoteViewModel(
            addNoteNavigationRepository = AddNoteNavigationRepositoryImpl(),
            addNoteUseCase = AddNoteUseCase(
                AddNoteRepositoryImpl(core.provideDataBase().notesDao())
            )
        )
    }
}