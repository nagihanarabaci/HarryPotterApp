package com.ao.harrypotterapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ao.harrypotterapp.data.model.Spells
import com.ao.harrypotterapp.data.repository.HarryPotterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SpellsViewModel @Inject constructor(var repo: HarryPotterRepository): ViewModel()  {
    var spellList = MutableLiveData<List<Spells>>()
    init {
        getSpells()

    }

    fun getSpells(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                spellList.value = repo.getSpells()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

}