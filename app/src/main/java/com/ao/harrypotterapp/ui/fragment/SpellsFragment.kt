package com.ao.harrypotterapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ao.harrypotterapp.R
import com.ao.harrypotterapp.databinding.FragmentSpellsBinding
import com.ao.harrypotterapp.ui.adapter.CharactersAdapter
import com.ao.harrypotterapp.ui.adapter.SpellsAdapter
import com.ao.harrypotterapp.ui.viewModel.CharactersViewModel
import com.ao.harrypotterapp.ui.viewModel.SpellsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SpellsFragment : Fragment() {

    private lateinit var binding: FragmentSpellsBinding
    private lateinit var viewModel: SpellsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSpellsBinding.inflate(inflater, container, false)


        setRecyclerViewOptions()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SpellsViewModel by viewModels()
        viewModel = tempViewModel

    }

    fun setRecyclerViewOptions(){
        viewModel.getSpells()
        viewModel.spellList.observe(viewLifecycleOwner){spellList->
            binding.rvSpells.layoutManager = LinearLayoutManager(requireContext())
            binding.rvSpells.adapter = SpellsAdapter(requireContext(), spellList)
        }

    }





}