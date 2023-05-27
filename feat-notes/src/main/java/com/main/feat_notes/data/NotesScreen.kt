package com.main.feat_notes.data

import com.main.core.data.BaseFragment
import com.main.core.presentation.Screen
import com.main.feat_notes.presentation.ui.NotesFragment

class NotesScreen : Screen() {
    override fun fragment(): Class<out BaseFragment<*>> {
        return NotesFragment::class.java
    }
}