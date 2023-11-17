package com.ao.harrypotterapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ao.harrypotterapp.data.model.Characters
import com.ao.harrypotterapp.data.repository.HarryPotterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(var repo: HarryPotterRepository): ViewModel() {
    var characterList =MutableLiveData<List<Characters>>()

    fun getCharacters(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                characterList.value = filterNotEmtyImage(repo.getCharacters())
            }catch (e:Exception){
                e.printStackTrace()
            }
        }

    }

    fun filterNotEmtyImage(list: List<Characters>): List<Characters> {
        return list.filter { it.image.isNotEmpty() }
    }

}