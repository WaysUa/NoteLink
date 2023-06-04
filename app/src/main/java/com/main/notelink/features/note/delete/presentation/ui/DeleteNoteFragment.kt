package com.main.notelink.features.note.delete.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import com.main.notelink.core.data.BaseFragment
import com.main.notelink.databinding.FragmentDeleteNoteBinding
import com.main.notelink.features.note.delete.presentation.viewmodel.DeleteNoteViewModel

class DeleteNoteFragment : BaseFragment<DeleteNoteViewModel>() {

    override val viewModelClass: Class<DeleteNoteViewModel> = DeleteNoteViewModel::class.java
    override val binding: ViewBinding by lazy { FragmentDeleteNoteBinding.inflate(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}