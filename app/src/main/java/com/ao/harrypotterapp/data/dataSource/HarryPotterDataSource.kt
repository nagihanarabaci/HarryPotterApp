package com.ao.harrypotterapp.data.dataSource

import com.ao.harrypotterapp.data.model.Characters
import com.ao.harrypotterapp.data.model.HouseCharacters
import com.ao.harrypotterapp.data.model.Spells
import com.ao.harrypotterapp.retrofit.HarryPotterDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HarryPotterDataSource(var dao:HarryPotterDao) {

    suspend fun getCharacters(): List<Characters>
        = withContext(Dispatchers.IO){
            return@withContext dao.getCharacters()
    }

    suspend fun getHufflepuff(): List<HouseCharacters>
        = withContext(Dispatchers.IO){
            return@withContext dao.getHufflepuff()
    }

    suspend fun getRavenclaw(): List<HouseCharacters>
        = withContext(Dispatchers.IO){
            return@withContext dao.getRavenclaw()
    }

    suspend fun getSlytherin(): List<HouseCharacters>
        = withContext(Dispatchers.IO){
            return@withContext dao.getSlytherin()
    }

    suspend fun getGryffindor(): List<HouseCharacters>
        = withContext(Dispatchers.IO){
            return@withContext dao.getGryffindor()
    }

    suspend fun getSpells(): List<Spells>
        = withContext(Dispatchers.IO){
            return@withContext dao.getSpells()
    }

}