package com.main.notelink.features.notes.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.main.notelink.R
import com.main.notelink.databinding.ItemNoteBinding
import com.main.notelink.features.note.common.data.Note

class NotesAdapter(
    private val onItemClick: (Note) -> Unit
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    private val notes = mutableListOf<Note>()

    class NotesViewHolder(view: View): ViewHolder(view) {
        private val binding by lazy { ItemNoteBinding.bind(view) }
        fun bind(note: Note, onItemClick: (Note) -> Unit) {
            binding.tvTitle.text = note.title
            binding.tvContent.text = note.content
            binding.itemNoteLayout.setOnClickListener { onItemClick.invoke(note) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(notes[position], onItemClick)
    }

    override fun getItemCount() = notes.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNotes(notes: List<Note>) {
        this.notes.clear()
        this.notes.addAll(notes.reversed())
        notifyDataSetChanged()
    }
}