package com.main.notelink.features.note.delete.sl

import com.main.notelink.core.sl.Core
import com.main.notelink.core.sl.Module
import com.main.notelink.features.note.delete.data.navigation.DeleteNoteNavigationRepositoryImpl
import com.main.notelink.features.note.delete.presentation.viewmodel.DeleteNoteViewModel

class DeleteNoteModule(private val core: Core) : Module<DeleteNoteViewModel> {
    override fun viewModel(): DeleteNoteViewModel {
        return DeleteNoteViewModel(
            deleteNoteNavigationRepository = DeleteNoteNavigationRepositoryImpl()
        )
    }
}