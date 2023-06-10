package com.main.notelink.features.note.edit.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.main.notelink.core.data.BaseFragment
import com.main.notelink.core.data.parcelable
import com.main.notelink.databinding.FragmentEditNoteBinding
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.edit.presentation.viewmodel.EditNoteViewModel
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EditNoteFragment : BaseFragment<EditNoteViewModel>() {

    override val viewModelClass: Class<EditNoteViewModel> = EditNoteViewModel::class.java
    override val binding by lazy { FragmentEditNoteBinding.inflate(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val note = arguments?.parcelable<Note>(NotesNavigationRepository.NOTE_DATA)
        binding.etTitle.setText(note?.title)
        binding.etContent.setText(note?.content)

        binding.btnBack.setOnClickListener {
            viewModel.updateNote(
                Note(
                    id = note?.id.toString().toInt(),
                    title = binding.etTitle.text.toString(),
                    content = binding.etContent.text.toString()
                )
            )
            lifecycleScope.launch {
                delay(25)
                viewModel.navigateToNotesFragment(findNavController())
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback {
            viewModel.updateNote(
                Note(
                    id = note?.id.toString().toInt(),
                    title = binding.etTitle.text.toString(),
                    content = binding.etContent.text.toString()
                )
            )
            lifecycleScope.launch {
                delay(25)
                viewModel.navigateToNotesFragment(findNavController())
            }
        }
    }
}
