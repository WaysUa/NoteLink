package com.main.notelink.features.note.delete.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewbinding.ViewBinding
import com.main.notelink.core.data.BaseFragment
import com.main.notelink.databinding.FragmentDeleteNoteBinding
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.delete.presentation.adapter.DeleteNotesAdapter
import com.main.notelink.features.note.delete.presentation.viewmodel.DeleteNoteViewModel

class DeleteNoteFragment : BaseFragment<DeleteNoteViewModel>() {

    override val viewModelClass: Class<DeleteNoteViewModel> = DeleteNoteViewModel::class.java
    override val binding by lazy { FragmentDeleteNoteBinding.inflate(layoutInflater) }
    private val adapter = DeleteNotesAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvNotes.layoutManager = StaggeredGridLayoutManager(2, 1)
        binding.rvNotes.adapter = adapter

        adapter.setNotes(listOf(
            Note(title = "Hello", content = "Wor12ld"),
            Note(title = "Hello32", content = "Wor6453ld"),
            Note(title = "Hello3232", content = "W8orld"),
            Note(title = "Hell4343o", content = "W7667orld"),
        ))
    }
}