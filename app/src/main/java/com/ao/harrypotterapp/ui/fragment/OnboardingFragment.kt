package com.ao.harrypotterapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ao.harrypotterapp.R
import com.ao.harrypotterapp.databinding.FragmentOnboardingBinding
import com.ao.harrypotterapp.ui.adapter.OnboardingViewPagerAdapter
import com.ao.harrypotterapp.utils.OnboardingHouses
import com.ao.harrypotterapp.utils.to

class OnboardingFragment : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.onboardHouseDescription.text = OnboardingHouses.entries.first().housesDescription
        viewPagerOptions()
        return binding.root
    }

    private fun viewPagerOptions() {
        binding.onboardingViewPager.adapter = OnboardingViewPagerAdapter(binding)
        binding.onboardingViewPager.registerOnPageChangeCallback(object :
            androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.onboardHouseDescription.text =
                    OnboardingHouses.entries[position].housesDescription
            }
        })
        binding.onboardNextButton.setOnClickListener {
            if (binding.onboardingViewPager.currentItem == OnboardingHouses.entries.size - 1) {
                Navigation.to(binding.root, R.id.onboarding_to_base)
            } else {
                binding.onboardingViewPager.currentItem =
                    binding.onboardingViewPager.currentItem + 1
            }
        }
    }
}