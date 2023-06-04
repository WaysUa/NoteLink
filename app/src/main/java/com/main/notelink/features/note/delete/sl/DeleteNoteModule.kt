package com.main.notelink.features.note.delete.sl

import com.main.notelink.core.sl.Core
import com.main.notelink.core.sl.Module
import com.main.notelink.features.note.delete.data.navigation.DeleteNoteNavigationRepositoryImpl
import com.main.notelink.features.note.delete.data.repository.DeleteNoteRepositoryImpl
import com.main.notelink.features.note.delete.domain.usecase.DeleteNoteUseCase
import com.main.notelink.features.note.delete.presentation.viewmodel.DeleteNoteViewModel

class DeleteNoteModule(private val core: Core) : Module<DeleteNoteViewModel> {
    override fun viewModel(): DeleteNoteViewModel {
        val deleteNoteUseCase = DeleteNoteUseCase(
            DeleteNoteRepositoryImpl(core.provideDataBase().notesDao())
        )
        return DeleteNoteViewModel(
            dispatchers = core.provideDispatchers(),
            deleteNoteUseCase = deleteNoteUseCase,
            deleteNoteNavigationRepository = DeleteNoteNavigationRepositoryImpl()
        )
    }
}