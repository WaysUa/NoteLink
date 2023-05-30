package com.main.notelink.features.notes.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.main.notelink.R
import com.main.notelink.databinding.ItemNoteBinding

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    private val notes = mutableListOf<String>()

    class NotesViewHolder(view: View): ViewHolder(view) {
        private val binding by lazy { ItemNoteBinding.bind(view) }
        fun bind(string: String) {
            binding.tvTitle.text = string
            binding.tvContent.text = (string + "" + string + string)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount() = notes.size

    @SuppressLint("NotifyDataSetChanged")
    fun addNotes(list: List<String>) {
        notes.addAll(list)
        notifyDataSetChanged()
    }
}