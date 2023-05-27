package com.main.core.sl

import com.main.core.presentation.NavigationCommunication

interface Core : ProvideNavigation {

    class Base : Core {
        private val navigationCommunication = NavigationCommunication.Base()

        override fun provideNavigation() = navigationCommunication
    }
}

interface ProvideNavigation {
    fun provideNavigation(): NavigationCommunication.Mutable
}