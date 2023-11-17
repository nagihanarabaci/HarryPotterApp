package com.ao.harrypotterapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ao.harrypotterapp.data.model.Characters
import com.ao.harrypotterapp.databinding.CharactersCardBinding
import com.bumptech.glide.Glide

class CharactersAdapter(private var context: Context, private var characterList: List<Characters>) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>(){

    inner class CharactersViewHolder(var design:CharactersCardBinding): RecyclerView.ViewHolder(design.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val binding = CharactersCardBinding.inflate(LayoutInflater.from(context), parent, false)
        return CharactersViewHolder(binding)
    }



    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val character = characterList[position]
        val design = holder.design
        design.tvName.text = character.name
        Glide.with(context).load(character.image).into(design.ivCharacter)

    }

    override fun getItemCount(): Int {
        return characterList.size
    }
}