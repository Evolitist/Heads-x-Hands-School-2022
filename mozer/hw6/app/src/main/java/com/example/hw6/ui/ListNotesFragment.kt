package com.example.hw6.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.hw6.R
import com.example.hw6.databinding.FragmentListNotesBinding

class ListNotesFragment : Fragment() {

    lateinit var binding: FragmentListNotesBinding
    private val noteAdapter = NoteAdapter()
    private val viewModel: ListNotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.grid.apply {
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter = noteAdapter
                .apply {
                setOnItemClick {
                    viewModel.deleteNotes(it)
//                    deleteNote(it)
//                    submitList(getNotes())
                }
            }
//            binding.fab.setOnClickListener {
////                putNote(MockDataSource.generateNote())
////                noteAdapter.submitList(getNotes())
//                viewModel.addNote()
//            }

            viewModel.notesLiveData.observe(viewLifecycleOwner) {
                noteAdapter.submitList(it)
            }

//            viewModel.loadNotes()
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listNotesFragment_to_addNoteFragment)
        }
    }
}