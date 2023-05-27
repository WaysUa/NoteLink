package com.main.notelink.sl

import androidx.lifecycle.ViewModel
import com.main.core.sl.Module
import com.main.notelink.data.MainModule
import com.main.notelink.presentation.viewmodel.MainViewModel

interface DependencyContainer {

    fun <T : ViewModel> module(clazz: Class<T>): Module<*>

    class Error : DependencyContainer {
        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> {
            throw IllegalStateException("no module found for $clazz")
        }
    }

    class Base(
        //private val core: Core,
        private val dependencyContainer: DependencyContainer = Error()
    ) : DependencyContainer {


        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> = when (clazz) {
            MainViewModel::class.java -> MainModule(/*core*/)
            else -> dependencyContainer.module(clazz)
        }
    }
}