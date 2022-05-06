package com.example.lesson6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson6.databinding.ItemNoteBinding

class NoteAdapter() : ListAdapter<Note, NoteAdapter.NoteViewHolder>(NoteItemCallBack) {

    lateinit var clickListener: ((Note) -> Unit)

    fun setOnItemClick(callback: (Note) -> Unit) {
        clickListener = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NoteViewHolder(
        private val binding: ItemNoteBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Note) {
            binding.textNote.text = item.text
            binding.root.setOnClickListener {
                clickListener(item)
            }
        }
    }

    private object NoteItemCallBack : DiffUtil.ItemCallback<Note>() {

        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
}