package com.ao.harrypotterapp.data.repository

import com.ao.harrypotterapp.data.dataSource.HarryPotterDataSource
import com.ao.harrypotterapp.utils.House

class HarryPotterRepository(var dataSource:HarryPotterDataSource) {
    suspend fun getCharacters() = dataSource.getCharacters()
    suspend fun getSpells() = dataSource.getSpells()
    suspend fun getHouseCharacters(house: House) = dataSource.getHouseCharacters(house)
}