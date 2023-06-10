package com.main.notelink.features.notes.sl

import com.main.notelink.core.sl.Core
import com.main.notelink.core.sl.Module
import com.main.notelink.features.notes.data.navigation.NotesNavigationRepositoryImpl
import com.main.notelink.features.notes.data.repository.GetNotesRepositoryImpl
import com.main.notelink.features.notes.domain.usecase.GetNotesUseCase
import com.main.notelink.features.notes.presentation.communication.NotesCommunication
import com.main.notelink.features.notes.presentation.communication.NotesListCommunication
import com.main.notelink.features.notes.presentation.viewmodel.NotesViewModel

class NotesModule(private val core: Core) : Module<NotesViewModel> {
    override fun viewModel(): NotesViewModel {
        val communication = NotesCommunication.Base(
            notesListCommunication = NotesListCommunication.Base()
        )
        val getNotesUseCase = GetNotesUseCase(
            GetNotesRepositoryImpl(core.provideDataBase().notesDao())
        )
        return NotesViewModel(
            dispatchers = core.provideDispatchers(),
            getNotesUseCase = getNotesUseCase,
            notesNavigationRepository = NotesNavigationRepositoryImpl(),
            notesCommunication = communication
        )
    }
}
