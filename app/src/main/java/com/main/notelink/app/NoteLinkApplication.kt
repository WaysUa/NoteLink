package com.main.notelink.app

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.main.core.sl.ProvideViewModel
import com.main.feat_add_note.sl.AddNoteCore
import com.main.feat_notes.sl.NotesCore
import com.main.notelink.sl.DependencyContainer
import com.main.notelink.sl.ViewModelsFactory

class NoteLinkApplication : Application(), ProvideViewModel {
    private lateinit var viewModelsFactory: ViewModelsFactory
    private lateinit var dependencyContainer: DependencyContainer.Base

    override fun onCreate() {
        super.onCreate()
        dependencyContainer = DependencyContainer.Base(
            notesCore = NotesCore.Base(),
            addNoteCore = AddNoteCore.Base()
        )
        viewModelsFactory = ViewModelsFactory(dependencyContainer)
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T {
        return ViewModelProvider(owner, viewModelsFactory)[clazz]
    }
}