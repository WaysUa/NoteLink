package com.main.notelink.features.note.delete.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.main.notelink.core.data.BaseFragment
import com.main.notelink.core.data.parcelable
import com.main.notelink.core.data.parcelableArrayList
import com.main.notelink.databinding.FragmentDeleteNoteBinding
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.delete.data.entities.NoteDeleteData
import com.main.notelink.features.note.delete.presentation.adapter.DeleteNotesAdapter
import com.main.notelink.features.note.delete.presentation.viewmodel.DeleteNoteViewModel
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository

class DeleteNoteFragment : BaseFragment<DeleteNoteViewModel>() {

    override val viewModelClass: Class<DeleteNoteViewModel> = DeleteNoteViewModel::class.java
    override val binding by lazy { FragmentDeleteNoteBinding.inflate(layoutInflater) }
    private val adapter = DeleteNotesAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notes = requireArguments().parcelableArrayList<NoteDeleteData>(NotesNavigationRepository.NOTES_LIST_DATA)?.toList()

        binding.rvNotes.layoutManager = StaggeredGridLayoutManager(2, 1)
        binding.rvNotes.adapter = adapter

        adapter.setNotes(notes ?: emptyList())

        binding.btnBack.setOnClickListener {
            viewModel.navigateToNotesFragment(findNavController())
        }

        requireActivity().onBackPressedDispatcher.addCallback {
            viewModel.navigateToNotesFragment(findNavController())
        }
    }
}