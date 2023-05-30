package com.main.notelink.main.sl

import android.content.Context

interface ProvideInstances {

    fun provideCacheModule(): CacheModule

    class Release(private val context: Context) : ProvideInstances {
        override fun provideCacheModule() = CacheModule.Base(context)
    }

    class Mock(private val context: Context) : ProvideInstances {
        override fun provideCacheModule() = CacheModule.Mock(context)
    }
}