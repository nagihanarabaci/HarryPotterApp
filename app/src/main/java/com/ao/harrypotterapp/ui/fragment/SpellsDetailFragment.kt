package com.ao.harrypotterapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.ao.harrypotterapp.R
import com.ao.harrypotterapp.data.model.Spells
import com.ao.harrypotterapp.databinding.FragmentSpellsDetailBinding
import com.ao.harrypotterapp.utils.Constants
import com.ao.harrypotterapp.utils.back
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpellsDetailFragment : Fragment() {
    private lateinit var binding: FragmentSpellsDetailBinding
    private lateinit var spells: Spells


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSpellsDetailBinding.inflate(inflater, container, false)
        setFragmentView()
        binding.toolbarTitle = Constants.spellsDetail
        binding.spellDetainTB.setNavigationIcon(R.drawable.back_icon)
        binding.spellDetainTB.setNavigationOnClickListener {
            Navigation.back(it)
        }
        return binding.root
    }

    private fun setFragmentView() {
        val bundle: SpellsDetailFragmentArgs by navArgs()
        spells = bundle.spells
        binding.tvSDName.text = spells.name
        binding.tvDescription.text = spells.description
    }
}