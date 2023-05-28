package com.main.feat_add_note.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import com.main.core.data.BaseFragment
import com.main.feat_add_note.databinding.FragmentAddNoteBinding
import com.main.feat_add_note.presentation.viewmodel.AddNoteViewModel

class AddNoteFragment : BaseFragment<AddNoteViewModel>() {

    override val viewModelClass: Class<AddNoteViewModel> = AddNoteViewModel::class.java
    override val binding: ViewBinding by lazy { FragmentAddNoteBinding.inflate(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}