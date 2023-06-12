package com.main.notelink.features.note.delete.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.main.notelink.core.data.BaseFragment
import com.main.notelink.core.data.parcelableArrayList
import com.main.notelink.databinding.FragmentDeleteNoteBinding
import com.main.notelink.features.note.delete.data.entities.NoteDeleteData
import com.main.notelink.features.note.delete.presentation.adapter.DeleteNotesAdapter
import com.main.notelink.features.note.delete.presentation.viewmodel.DeleteNoteViewModel
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DeleteNoteFragment : BaseFragment<DeleteNoteViewModel>() {

    override val viewModelClass: Class<DeleteNoteViewModel> = DeleteNoteViewModel::class.java
    override val binding by lazy { FragmentDeleteNoteBinding.inflate(layoutInflater) }
    private val adapter = DeleteNotesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notes = requireArguments().parcelableArrayList<NoteDeleteData>(
            NotesNavigationRepository.NOTES_LIST_DATA
        )?.toList()
        adapter.setNotes(notes ?: emptyList())

        binding.rvNotes.layoutManager = StaggeredGridLayoutManager(2, 1)
        binding.rvNotes.adapter = adapter

        binding.btnClose.setOnClickListener {
            lifecycleScope.launch {
                delay(25)
                viewModel.navigateToNotesFragment(findNavController())
            }
        }

        binding.btnDelete.setOnClickListener {
            // todo improve code delay(25) to navigation repository
            adapter.getAllCheckedNotes().forEach { noteDeleteData ->
                viewModel.deleteNote(noteDeleteData)
            }
            lifecycleScope.launch {
                delay(25)
                viewModel.navigateToNotesFragment(findNavController())
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback {
            lifecycleScope.launch {
                delay(25)
                viewModel.navigateToNotesFragment(findNavController())
            }
        }
    }
}
