package com.main.notelink.features.notes.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.main.core_datasource.data.cache.NotesDao
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository

class NotesViewModel(
    private val dao: NotesDao,
    private val notesNavigationRepository: NotesNavigationRepository
    //todo correct this code
): ViewModel(), NotesNavigationRepository {

    fun init () {
        dao.getAllNotes().forEach {
            Log.d("MyLog", "item number: ${it.id} data: title: ${it.title} content: ${it.content}")
        }
    }


    override fun navigateToAddNoteFragment(navController: NavController) {
        notesNavigationRepository.navigateToAddNoteFragment(navController)
    }
}