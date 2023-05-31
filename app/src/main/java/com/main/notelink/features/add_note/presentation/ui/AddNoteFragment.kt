package com.main.notelink.features.add_note.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.main.notelink.main.data.base.BaseFragment
import com.main.notelink.main.data.cache.entities.NoteCache
import com.main.notelink.databinding.FragmentAddNoteBinding
import com.main.notelink.features.add_note.domain.repository.AddNoteRepository
import com.main.notelink.features.add_note.presentation.viewmodel.AddNoteViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteFragment : BaseFragment<AddNoteViewModel>() {

    override val viewModelClass: Class<AddNoteViewModel> = AddNoteViewModel::class.java
    override val binding by lazy { FragmentAddNoteBinding.inflate(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            viewModel.addNote(
                NoteCache(
                    title = binding.etTitle.text.toString(),
                    content = binding.etContent.text.toString()
                )
            )
            viewModel.navigateToNotesFragment(findNavController())
        }

        activity.onBackPressedDispatcher.addCallback {
            viewModel.addNote(
                NoteCache(
                    title = binding.etTitle.text.toString(),
                    content = binding.etContent.text.toString()
                )
            )
            viewModel.navigateToNotesFragment(findNavController())
        }
    }
}