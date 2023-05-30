package com.main.notelink.main.sl

interface Core:  CacheModule {

    class Base(
        private val provideInstances: ProvideInstances
    ) : Core {

        private val cacheModule by lazy {
            provideInstances.provideCacheModule()
        }

        override fun provideDataBase() = cacheModule.provideDataBase()
    }
}