package com.main.notelink.features.note.edit.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.main.notelink.core.data.base.BaseFragment
import com.main.notelink.databinding.FragmentEditNoteBinding
import com.main.notelink.features.note.edit.presentation.viewmodel.EditNoteViewModel

class EditNoteFragment : BaseFragment<EditNoteViewModel>() {

    override val viewModelClass: Class<EditNoteViewModel> = EditNoteViewModel::class.java
    override val binding by lazy { FragmentEditNoteBinding.inflate(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}