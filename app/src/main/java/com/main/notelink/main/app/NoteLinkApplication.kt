package com.main.notelink.main.app

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.main.core.sl.ProvideViewModel
import com.main.core_datasource.sl.CacheModule
import com.main.notelink.features.add_note.sl.AddNoteCore
import com.main.notelink.features.notes.sl.NotesCore
import com.main.notelink.main.sl.DependencyContainer
import com.main.notelink.main.sl.ViewModelsFactory

class NoteLinkApplication : Application(), ProvideViewModel {
    private lateinit var viewModelsFactory: ViewModelsFactory
    private lateinit var dependencyContainer: DependencyContainer.Base

    override fun onCreate() {
        super.onCreate()
        val cacheModule = CacheModule.Base(context = applicationContext)
        dependencyContainer = DependencyContainer.Base(
            notesCore = NotesCore.Base(cacheModule),
            addNoteCore = AddNoteCore.Base(cacheModule)
        )
        viewModelsFactory = ViewModelsFactory(dependencyContainer)
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T {
        return ViewModelProvider(owner, viewModelsFactory)[clazz]
    }
}