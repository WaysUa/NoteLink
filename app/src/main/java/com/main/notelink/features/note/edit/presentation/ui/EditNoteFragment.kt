package com.main.notelink.features.note.edit.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import com.main.notelink.core.data.BaseFragment
import com.main.notelink.core.data.parcelable
import com.main.notelink.databinding.FragmentEditNoteBinding
import com.main.notelink.features.note.common.data.Note
import com.main.notelink.features.note.edit.presentation.viewmodel.EditNoteViewModel
import com.main.notelink.features.notes.domain.navigation.NotesNavigationRepository

class EditNoteFragment : BaseFragment<EditNoteViewModel>() {

    override val viewModelClass: Class<EditNoteViewModel> = EditNoteViewModel::class.java
    override val binding by lazy { FragmentEditNoteBinding.inflate(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val note = arguments?.parcelable<Note>(NotesNavigationRepository.NOTE_DATA)
        Log.d("MyLog", "EditNoteFragment: $note")
    }
}