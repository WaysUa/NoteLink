package com.main.notelink.features.add_note.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.main.core.data.BaseFragment
import com.main.core_datasource.data.cache.NoteCache
import com.main.feat_add_note.databinding.FragmentAddNoteBinding
import com.main.notelink.features.add_note.presentation.viewmodel.AddNoteViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteFragment : BaseFragment<AddNoteViewModel>() {

    override val viewModelClass: Class<AddNoteViewModel> = AddNoteViewModel::class.java
    override val binding by lazy { FragmentAddNoteBinding.inflate(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.addNote(NoteCache(title = "Hello", content = "World"))
        }

        binding.btnBack.setOnClickListener {
            viewModel.navigateToNotesFragment(findNavController())
        }
    }
}