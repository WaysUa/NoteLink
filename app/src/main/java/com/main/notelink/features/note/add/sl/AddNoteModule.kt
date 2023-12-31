package com.main.notelink.features.note.add.sl

import com.main.notelink.core.sl.Core
import com.main.notelink.core.sl.Module
import com.main.notelink.features.note.add.data.navigation.AddNoteNavigationRepositoryImpl
import com.main.notelink.features.note.add.data.repository.AddNoteRepositoryImpl
import com.main.notelink.features.note.add.domain.usecase.AddNoteUseCase
import com.main.notelink.features.note.add.presentation.viewmodel.AddNoteViewModel

class AddNoteModule(private val core: Core) : Module<AddNoteViewModel> {
    override fun viewModel(): AddNoteViewModel {
        val addNoteUseCase = AddNoteUseCase(
            AddNoteRepositoryImpl(core.provideDataBase().notesDao())
        )
        return AddNoteViewModel(
            dispatchers = core.provideDispatchers(),
            addNoteUseCase = addNoteUseCase,
            addNoteNavigationRepository = AddNoteNavigationRepositoryImpl()
        )
    }
}
