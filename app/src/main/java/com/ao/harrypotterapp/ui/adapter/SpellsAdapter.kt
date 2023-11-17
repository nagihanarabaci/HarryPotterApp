package com.ao.harrypotterapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ao.harrypotterapp.data.model.Spells
import com.ao.harrypotterapp.databinding.SpellsCardBinding
import com.ao.harrypotterapp.ui.fragment.BaseFragmentDirections
import com.ao.harrypotterapp.ui.viewModel.SpellsViewModel
import com.ao.harrypotterapp.utils.to

class SpellsAdapter(private var context: Context, private var spellsList: List<Spells>) :
    RecyclerView.Adapter<SpellsAdapter.SpellsViewHolder>() {
    inner class SpellsViewHolder(var design: SpellsCardBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellsViewHolder {
        var binding = SpellsCardBinding.inflate(LayoutInflater.from(context), parent, false)
        return SpellsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return spellsList.size
    }

    override fun onBindViewHolder(holder: SpellsViewHolder, position: Int) {
        var spell = spellsList[position]
        var design = holder.design
        design.tvSName.text = spell.name
        design.cvSpells.setOnClickListener {
            val direction = BaseFragmentDirections.basetoSpellsDetail(spell)
            Navigation.to(it, direction)
        }

    }


}