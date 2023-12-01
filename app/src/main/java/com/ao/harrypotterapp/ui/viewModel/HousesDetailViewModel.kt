package com.ao.harrypotterapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ao.harrypotterapp.data.model.HouseCharacters
import com.ao.harrypotterapp.data.repository.HarryPotterRepository
import com.ao.harrypotterapp.utils.House
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HousesDetailViewModel @Inject constructor(var repo: HarryPotterRepository) : ViewModel() {
    var housesList = MutableLiveData<List<HouseCharacters>>()
    fun getHouses(house: House){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                housesList.value = repo.getHouseCharacters(house)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}