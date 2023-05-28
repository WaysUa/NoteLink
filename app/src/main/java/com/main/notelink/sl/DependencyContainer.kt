package com.main.notelink.sl

import androidx.lifecycle.ViewModel
import com.main.core.sl.Module
import com.main.feat_add_note.presentation.viewmodel.AddNoteViewModel
import com.main.feat_add_note.sl.AddNoteCore
import com.main.feat_add_note.sl.AddNoteModule
import com.main.feat_notes.presentation.viewmodel.NotesViewModel
import com.main.feat_notes.sl.NotesCore
import com.main.feat_notes.sl.NotesModule

interface DependencyContainer {

    fun <T : ViewModel> module(clazz: Class<T>): Module<*>

    class Error : DependencyContainer {
        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> {
            throw IllegalStateException("no module found for $clazz")
        }
    }

    class Base(
        private val notesCore: NotesCore,
        private val addNoteCore: AddNoteCore,
        private val dependencyContainer: DependencyContainer = Error()
    ) : DependencyContainer {


        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> = when (clazz) {
            NotesViewModel::class.java -> NotesModule(notesCore)
            AddNoteViewModel::class.java -> AddNoteModule(addNoteCore)
            else -> dependencyContainer.module(clazz)
        }
    }
}