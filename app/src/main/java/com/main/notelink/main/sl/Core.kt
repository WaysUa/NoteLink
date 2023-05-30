package com.main.notelink.main.sl

import com.main.notelink.main.presentation.DispatchersList

interface Core :  CacheModule {

    fun provideDispatchers(): DispatchersList

    class Base(
        private val provideInstances: ProvideInstances
    ) : Core {

        private val cacheModule by lazy {
            provideInstances.provideCacheModule()
        }

        private val dispatchersList by lazy {
            DispatchersList.Base()
        }

        override fun provideDispatchers() = dispatchersList

        override fun provideDataBase() = cacheModule.provideDataBase()
    }
}