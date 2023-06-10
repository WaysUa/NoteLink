package com.main.notelink.features.note.edit.sl

import com.main.notelink.core.sl.Core
import com.main.notelink.core.sl.Module
import com.main.notelink.features.note.edit.data.navigation.EditNoteNavigationRepositoryImpl
import com.main.notelink.features.note.edit.data.repository.EditNoteRepositoryImpl
import com.main.notelink.features.note.edit.domain.usecase.EditNoteUseCase
import com.main.notelink.features.note.edit.presentation.viewmodel.EditNoteViewModel

class EditNoteModule(private val core: Core) : Module<EditNoteViewModel> {
    override fun viewModel(): EditNoteViewModel {
        val editNoteUseCase = EditNoteUseCase(
            EditNoteRepositoryImpl(core.provideDataBase().notesDao())
        )
        return EditNoteViewModel(
            dispatchers = core.provideDispatchers(),
            editNoteUseCase = editNoteUseCase,
            editNoteNavigationRepository = EditNoteNavigationRepositoryImpl()
        )
    }
}
