package com.main.notelink.data

import com.main.core.sl.Core
import com.main.core.sl.Module
import com.main.notelink.presentation.viewmodel.MainViewModel

class MainModule(private val core: Core) : Module<MainViewModel> {

    override fun viewModel(): MainViewModel {
        return MainViewModel(
            navigationCommunication = core.provideNavigation()
        )
    }
}