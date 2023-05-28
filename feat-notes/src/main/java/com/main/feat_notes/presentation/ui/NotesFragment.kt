package com.main.feat_notes.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.main.core.data.BaseFragment
import com.main.feat_notes.databinding.FragmentNotesBinding
import com.main.feat_notes.presentation.adapter.NotesAdapter
import com.main.feat_notes.presentation.viewmodel.NotesViewModel

class NotesFragment : BaseFragment<NotesViewModel.Base>() {

    override val viewModelClass: Class<NotesViewModel.Base> = NotesViewModel.Base::class.java
    override val binding by lazy { FragmentNotesBinding.inflate(layoutInflater) }

    private val adapter = NotesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddNote.setOnClickListener {

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