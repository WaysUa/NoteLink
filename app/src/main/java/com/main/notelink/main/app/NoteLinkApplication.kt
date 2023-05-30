package com.main.notelink.main.app

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.main.notelink.main.sl.ProvideViewModel
import com.main.notelink.main.sl.Core
import com.main.notelink.main.sl.DependencyContainer
import com.main.notelink.main.sl.ProvideInstances
import com.main.notelink.main.sl.ViewModelsFactory

class NoteLinkApplication : Application(), ProvideViewModel {
    private lateinit var viewModelsFactory: ViewModelsFactory
    private lateinit var dependencyContainer: DependencyContainer.Base

    override fun onCreate() {
        super.onCreate()
        val provideInstances = ProvideInstances.Release(this)
        dependencyContainer = DependencyContainer.Base(core = Core.Base(provideInstances))
        viewModelsFactory = ViewModelsFactory(dependencyContainer)
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T {
        return ViewModelProvider(owner, viewModelsFactory)[clazz]
    }
}