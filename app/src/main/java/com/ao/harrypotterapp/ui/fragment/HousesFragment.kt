package com.ao.harrypotterapp.ui.fragment

import android.icu.lang.UCharacter.toLowerCase
import android.icu.lang.UCharacter.toUpperCase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ao.harrypotterapp.R
import com.ao.harrypotterapp.data.model.HousesCardModel
import com.ao.harrypotterapp.databinding.FragmentHousesBinding
import com.ao.harrypotterapp.utils.House
import com.ao.harrypotterapp.utils.HousesCard
import com.ao.harrypotterapp.utils.to
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HousesFragment : Fragment() {
    private lateinit var binding: FragmentHousesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHousesBinding.inflate(inflater, container, false)
        binding.housesFragment = this
        return binding.root
    }

    fun housesOnClick(view: View) {
        val newView: ImageView = view as ImageView
        val model = HousesCardModel(getImageName(newView), getBackgroundResource(newView), House.valueOf(getTitle(newView)))
        val direction = BaseFragmentDirections.baseToHousesDetail(model)
        Navigation.to(view, direction)
    }

    private fun getImageName(view: View): String {
        return view.resources.getResourceEntryName(view.id)
    }

    private fun getBackgroundResource(view:ImageView): Int {
        return HousesCard.entries.firstOrNull{toLowerCase(it.name) == view.contentDescription.toString()}?.cardResource ?: R.drawable.gryffindor_card
    }

    private fun getTitle(view: ImageView): String {
        val content = view.contentDescription.toString().split("_").first()
        return toUpperCase(content)
    }
}