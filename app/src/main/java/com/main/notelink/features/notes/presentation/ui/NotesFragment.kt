package com.main.notelink.features.notes.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.main.notelink.core.data.BaseFragment
import com.main.notelink.databinding.FragmentNotesBinding
import com.main.notelink.features.notes.presentation.adapter.NotesAdapter
import com.main.notelink.features.notes.presentation.viewmodel.NotesViewModel

class NotesFragment : BaseFragment<NotesViewModel>() {

    override val viewModelClass: Class<NotesViewModel> = NotesViewModel::class.java
    override val binding by lazy { FragmentNotesBinding.inflate(layoutInflater) }
    private val adapter = NotesAdapter(
        onItemClick = { note -> viewModel.navigateToEditNoteFragment(findNavController(), note) },
        onItemLongClick = { notes ->
            viewModel.navigateToDeleteNoteFragment(findNavController(), ArrayList(notes))
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Log.d("MyLog", "NotesFragment: send intent success")
//
//        val intent = Intent("com.main.notelink.DATA_UPDATED")
//        requireActivity().sendBroadcast(intent)

        binding.rvNotes.layoutManager = StaggeredGridLayoutManager(2, 1)
        binding.rvNotes.adapter = adapter

        binding.btnAddNote.setOnClickListener {
            viewModel.navigateToAddNoteFragment(findNavController())
        }

        viewModel.observeNotesList(this) { notes ->
            adapter.setNotes(notes)
        }

        viewModel.getNotes()
    }
}
