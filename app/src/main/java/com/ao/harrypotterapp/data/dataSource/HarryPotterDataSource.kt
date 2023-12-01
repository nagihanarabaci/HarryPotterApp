package com.ao.harrypotterapp.data.dataSource

import com.ao.harrypotterapp.data.model.Characters
import com.ao.harrypotterapp.data.model.HouseCharacters
import com.ao.harrypotterapp.data.model.Spells
import com.ao.harrypotterapp.retrofit.HarryPotterDao
import com.ao.harrypotterapp.utils.House
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class HarryPotterDataSource(var dao:HarryPotterDao) {

    suspend fun getCharacters(): List<Characters>
        = withContext(Dispatchers.IO){
            return@withContext dao.getCharacters()
    }
    suspend fun getHouseCharacters(house: House): List<HouseCharacters> =
        withContext(Dispatchers.IO) {
            return@withContext when (house) {
                House.HUFFLEPUFF -> dao.getHufflepuff()
                House.RAVENCLAW -> dao.getRavenclaw()
                House.SLYTHERIN -> dao.getSlytherin()
                House.GRYFFINDOR -> dao.getGryffindor()
            }

        }

    suspend fun getSpells(): List<Spells>
        = withContext(Dispatchers.IO){
            return@withContext dao.getSpells()
    }

}