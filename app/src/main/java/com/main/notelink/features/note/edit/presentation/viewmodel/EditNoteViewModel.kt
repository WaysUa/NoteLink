package com.main.notelink.features.note.edit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.notelink.features.note.add.domain.navigation.AddNoteNavigationRepository
import com.main.notelink.features.note.edit.domain.navigation.EditNoteNavigationRepository
import com.main.notelink.features.note.edit.domain.usecase.EditNoteUseCase
import com.main.notelink.main.presentation.DispatchersList

class EditNoteViewModel(
    private val dispatchers: DispatchersList,
    private val editNoteUseCase: EditNoteUseCase,
    private val editNoteNavigationRepository: EditNoteNavigationRepository
) : ViewModel() {

}