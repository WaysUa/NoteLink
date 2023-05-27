package com.main.notelink.presentation.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.main.core.presentation.Communication
import com.main.core.presentation.Init
import com.main.core.presentation.NavigationCommunication
import com.main.core.presentation.NavigationStrategy
import com.main.feat_notes.data.NotesScreen

class MainViewModel(
    private val navigationCommunication: NavigationCommunication.Mutable
) : ViewModel(), Init, Communication.Observe<NavigationStrategy> {

    override fun observe(owner: LifecycleOwner, observer: Observer<NavigationStrategy>) {
        navigationCommunication.observe(owner, observer)
    }

    override fun init(isFirstRun: Boolean) {
        if (isFirstRun) {
            navigationCommunication.map(NavigationStrategy.Replace(NotesScreen))
        }
    }
}