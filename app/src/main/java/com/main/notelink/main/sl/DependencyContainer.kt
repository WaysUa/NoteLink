package com.main.notelink.main.sl

import androidx.lifecycle.ViewModel
import com.main.notelink.features.add_note.presentation.viewmodel.AddNoteViewModel
import com.main.notelink.features.add_note.sl.AddNoteModule
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
            else -> dependencyContainer.module(clazz)
        }
    }
}