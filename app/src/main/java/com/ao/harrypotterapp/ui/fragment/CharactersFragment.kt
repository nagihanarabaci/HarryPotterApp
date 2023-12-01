package com.ao.harrypotterapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ao.harrypotterapp.databinding.FragmentCharactersBinding
import com.ao.harrypotterapp.ui.adapter.CharactersAdapter
import com.ao.harrypotterapp.ui.viewModel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {
    //private val binding by viewBinding(FragmentCharactersBinding::bind)
    private lateinit var binding: FragmentCharactersBinding
    private val viewModel: CharactersViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        setRecyclerViewOptions()
        return binding.root
    }


    private fun setRecyclerViewOptions(){
        viewModel.getCharacters()
        viewModel.characterList.observe(viewLifecycleOwner){characterList->
            binding.charactersRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            binding.charactersRv.adapter = CharactersAdapter(requireContext(), characterList)
        }

    }

}