package com.ao.harrypotterapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ao.harrypotterapp.R
import com.ao.harrypotterapp.databinding.FragmentBaseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseFragment : Fragment() {
    private lateinit var binding: FragmentBaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBaseBinding.inflate(inflater, container, false)
        bottomNavBarOptions()
        return binding.root
    }

    private val selectedItem = R.id.charactersMenu

    private fun bottomNavBarOptions() {
        binding.bottomNavigationView.selectedItemId = selectedItem
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.charactersMenu -> {
                    replaceFragment(CharactersFragment())
                    true
                }

                R.id.housesMenu -> {
                    replaceFragment(HousesFragment())
                    true
                }

                R.id.spellsMenu -> {
                    replaceFragment(SpellsFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.baseFragmentContainer, fragment)
            .commit()
    }
}