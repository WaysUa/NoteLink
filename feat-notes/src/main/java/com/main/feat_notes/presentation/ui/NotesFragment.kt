package com.main.feat_notes.presentation.ui

import com.main.core.data.BaseFragment
import com.main.feat_notes.databinding.FragmentNotesBinding

class NotesFragment : BaseFragment<Any?>() {
    override val binding by lazy { FragmentNotesBinding.inflate(layoutInflater) }
}