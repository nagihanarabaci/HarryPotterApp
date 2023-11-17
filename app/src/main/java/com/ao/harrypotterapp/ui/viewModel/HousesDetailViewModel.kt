package com.ao.harrypotterapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ao.harrypotterapp.data.model.HouseCharacters
import com.ao.harrypotterapp.data.repository.HarryPotterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HousesDetailViewModel @Inject constructor(var repo: HarryPotterRepository) : ViewModel() {
    var housesList = MutableLiveData<List<HouseCharacters>>()


    fun getHufflepuff() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                housesList.value = repo.getHufflepuff()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getGryffindor() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                housesList.value = repo.getGryffindor()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getRavenclaw() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                housesList.value = repo.getRavenclaw()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getSlytherin() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                housesList.value = repo.getSlytherin()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}