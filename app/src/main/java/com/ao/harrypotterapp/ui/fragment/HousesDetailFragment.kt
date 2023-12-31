package com.ao.harrypotterapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.ao.harrypotterapp.R
import com.ao.harrypotterapp.data.model.HousesCardModel
import com.ao.harrypotterapp.databinding.FragmentHousesDetailBinding
import com.ao.harrypotterapp.ui.adapter.HousesDetailCardAdapter
import com.ao.harrypotterapp.ui.viewModel.HousesDetailViewModel
import com.ao.harrypotterapp.utils.back
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class HousesDetailFragment : Fragment() {

    private lateinit var binding: FragmentHousesDetailBinding
    private lateinit var viewModel: HousesDetailViewModel
    private lateinit var housesCardModel: HousesCardModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHousesDetailBinding.inflate(inflater, container, false)
        val bundle: HousesDetailFragmentArgs by navArgs()
        housesCardModel = bundle.housesCardModel
        setToolbarOptions()
        setRecyclerViewOptions()
        binding.housesDetailToolbar.setNavigationIcon(R.drawable.back_icon_white)
        binding.housesDetailToolbar.setNavigationOnClickListener {
            Navigation.back(it)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HousesDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    private fun setToolbarOptions() {
        binding.housesDetailToolbar.setBackgroundResource(housesCardModel.backgroundResource)
        binding.housesDetailToolbar.title = housesCardModel.house.housesName
    }

    private fun setRecyclerViewOptions() {
        runBlocking {
            launch {
                    viewModel.getHouses(housesCardModel.house)
            }
        }
        viewModel.housesList.observe(viewLifecycleOwner) {
            val adapter =
                HousesDetailCardAdapter(requireContext(), it, housesCardModel.backgroundResource)
            binding.housesDetailRv.adapter = adapter
        }
    }
}