package com.ao.harrypotterapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ao.harrypotterapp.databinding.FragmentOnboardingBinding
import com.ao.harrypotterapp.databinding.OnboardingViewPagerItemBinding
import com.ao.harrypotterapp.utils.OnboardingHouses

class OnboardingViewPagerAdapter(private var binding: FragmentOnboardingBinding) :
    RecyclerView.Adapter<OnboardingViewPagerAdapter.OnboardingViewHolder>() {

    inner class OnboardingViewHolder(var design: OnboardingViewPagerItemBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val binding = OnboardingViewPagerItemBinding.inflate(
            LayoutInflater.from(binding.root.context),
            parent,
            false
        )
        return OnboardingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return OnboardingHouses.entries.size
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        val house = OnboardingHouses.entries[position]
        val design = holder.design
        design.imageView.setImageResource(house.housesImage)
    }
}