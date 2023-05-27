package com.main.notelink.data

import com.main.core.sl.Module
import com.main.notelink.presentation.viewmodel.MainViewModel

class MainModule : Module<MainViewModel> {
    override fun viewModel(): MainViewModel {
        return MainViewModel()
    }
}