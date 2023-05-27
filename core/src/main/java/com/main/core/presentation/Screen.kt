package com.main.core.presentation

import com.main.core.data.BaseFragment

abstract class Screen {

    abstract fun fragment(): Class<out BaseFragment<*>>
}