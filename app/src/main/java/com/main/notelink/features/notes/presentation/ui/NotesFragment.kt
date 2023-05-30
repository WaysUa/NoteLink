package com.main.notelink.features.notes.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.main.notelink.main.data.base.BaseFragment
import com.main.notelink.databinding.FragmentNotesBinding
import com.main.notelink.features.notes.presentation.adapter.NotesAdapter
import com.main.notelink.features.notes.presentation.viewmodel.NotesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesFragment : BaseFragment<NotesViewModel>() {

    override val viewModelClass: Class<NotesViewModel> = NotesViewModel::class.java
    override val binding by lazy { FragmentNotesBinding.inflate(layoutInflater) }

    private val adapter = NotesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("MyLog", "NotesFragment: init")

        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.getNotes().forEach {
                Log.d("MyLog", "NotesFragment: item: $it")
            }
        }

        binding.btnAddNote.setOnClickListener {
            viewModel.navigateToAddNoteFragment(findNavController())
        }

        binding.rvNotes.layoutManager = StaggeredGridLayoutManager(2, 1)
        binding.rvNotes.adapter = adapter
        adapter.addNotes(
            listOf(
                "hellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohello",
                "hello",
                "hellohellohellohellohellohello",
                "hello",
                "hellohellohellohellohellohellohellohellohellohellohello",
                "hello",
                "hellohellohellohello",
                "hello",
                "hello",
                "hello",
                "hellodsdssssssss",
                "hellodsdssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaa112ss",
                "hellodsdaaaaaaaaaaaaaaaa112ss",
            )
        )
    }
}