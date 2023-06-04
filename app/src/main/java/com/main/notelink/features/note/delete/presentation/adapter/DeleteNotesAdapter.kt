package com.main.notelink.features.note.delete.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.main.notelink.R
import com.main.notelink.databinding.ItemDeleteNoteBinding
import com.main.notelink.databinding.ItemNoteBinding
import com.main.notelink.features.note.delete.data.entities.NoteDeleteData

class DeleteNotesAdapter(
) : RecyclerView.Adapter<DeleteNotesAdapter.NotesViewHolder>() {
    private val notes = mutableListOf<NoteDeleteData>()

    class NotesViewHolder(view: View): ViewHolder(view) {
        private val binding by lazy { ItemDeleteNoteBinding.bind(view) }

        fun bind(note: NoteDeleteData) {
            binding.tvTitle.text = note.title
            binding.tvContent.text = note.content
            binding.checkBoxDelete.isChecked = note.isChecked
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_delete_note, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount() = notes.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNotes(notes: List<NoteDeleteData>) {
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()
    }
}