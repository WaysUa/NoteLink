package com.main.notelink.core.sl

import androidx.lifecycle.ViewModel
import com.main.notelink.features.note.add.presentation.viewmodel.AddNoteViewModel
import com.main.notelink.features.note.add.sl.AddNoteModule
import com.main.notelink.features.note.edit.presentation.viewmodel.EditNoteViewModel
import com.main.notelink.features.note.edit.sl.EditNoteModule
import com.main.notelink.features.notes.presentation.viewmodel.NotesViewModel
import com.main.notelink.features.notes.sl.NotesModule

interface DependencyContainer {

    fun <T : ViewModel> module(clazz: Class<T>): Module<*>

    class Error : DependencyContainer {
        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> {
            throw IllegalStateException("no module found for $clazz")
        }
    }

    class Base(
        private val core: Core,
        private val dependencyContainer: DependencyContainer = Error()
    ) : DependencyContainer {

        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> = when (clazz) {
            NotesViewModel::class.java -> NotesModule(core)
            AddNoteViewModel::class.java -> AddNoteModule(core)
            EditNoteViewModel::class.java -> EditNoteModule(core)
            else -> dependencyContainer.module(clazz)
        }
    }
}