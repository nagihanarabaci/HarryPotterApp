package com.ao.harrypotterapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.ao.harrypotterapp.R
import com.ao.harrypotterapp.data.model.HousesCardModel
import com.ao.harrypotterapp.databinding.FragmentHousesBinding
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
        val model = HousesCardModel(getImageName(newView), getBackgroundResource(newView), getTitle(newView))
        val direction = BaseFragmentDirections.baseToHousesDetail(model)
        Navigation.to(view, direction)
    }

    private fun getImageName(view: View): String {
        return view.resources.getResourceEntryName(view.id)
    }

    private fun getBackgroundResource(view:ImageView): Int {
        return when(view.contentDescription.toString()) {
            "gryffindor_card" -> R.drawable.gryffindor_card
            "hufflepuff_card" -> R.drawable.hufflepuff_card
            "ravenclaw_card" -> R.drawable.ravenclaw_card
            "slytherin_card" -> R.drawable.slytherin_card
            else -> R.drawable.gryffindor_card
        }
    }

    private fun getTitle(view:ImageView): String {
        val content = view.contentDescription.toString().split("_").first().replaceFirstChar { it.uppercase() }
        return "$content Houses Characters"
    }
}