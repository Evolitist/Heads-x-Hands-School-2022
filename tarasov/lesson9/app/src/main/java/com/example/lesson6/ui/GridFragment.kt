package com.example.lesson6.ui

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.lesson6.R
import com.example.lesson6.databinding.FragmentGridBinding

class GridFragment : Fragment() {

    private lateinit var binding: FragmentGridBinding
    private val viewModel: MainViewModel by viewModels()
    private val noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGridBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.grid.apply {
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter = noteAdapter
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_gridFragment_to_noteFragment)
        }

        viewModel.notesLiveData.observe(viewLifecycleOwner) {
            noteAdapter.submitList(it)
        }

        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.deleteNote(viewHolder.adapterPosition)
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                val trashBinIcon = resources.getDrawable(R.drawable.ic_delete_red, null)
                c.clipRect(
                    viewHolder.itemView.left.toFloat(), viewHolder.itemView.top.toFloat(),
                    viewHolder.itemView.right.toFloat(), viewHolder.itemView.bottom.toFloat()
                )

                c.drawColor(resources.getColor(R.color.md_theme_dark_error, null))

                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )

                trashBinIcon.bounds = Rect(

                )


                trashBinIcon.draw(c)
            }
        }

        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.grid)

    }
}