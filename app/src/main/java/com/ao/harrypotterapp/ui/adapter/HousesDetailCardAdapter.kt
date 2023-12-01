package com.ao.harrypotterapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ao.harrypotterapp.data.model.HouseCharacters
import com.ao.harrypotterapp.databinding.HousesDetailCardBinding
import com.ao.harrypotterapp.utils.Constants

class HousesDetailCardAdapter(
    private var context: Context,
    private var houseList: List<HouseCharacters>,
    private val cardResource: Int
) : RecyclerView.Adapter<HousesDetailCardAdapter.HousesDetailCardViewHolder>() {
    inner class HousesDetailCardViewHolder(var design: HousesDetailCardBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HousesDetailCardViewHolder {
        val binding = HousesDetailCardBinding.inflate(LayoutInflater.from(context), parent, false)
        return HousesDetailCardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return houseList.size
    }

    override fun onBindViewHolder(holder: HousesDetailCardViewHolder, position: Int) {
        val character = houseList[position]
        val design = holder.design
        design.tvHName.text = character.name
        design.tvStudent.text = if (character.hogwartsStudent) Constants.student else Constants.staff
        design.cvHouse.setBackgroundResource(cardResource)
    }
}