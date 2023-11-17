package com.ao.harrypotterapp.data.repository

import com.ao.harrypotterapp.data.dataSource.HarryPotterDataSource

class HarryPotterRepository(var dataSource:HarryPotterDataSource) {

    suspend fun getCharacters() = dataSource.getCharacters()
    suspend fun getHufflepuff() = dataSource.getHufflepuff()
    suspend fun getRavenclaw() = dataSource.getRavenclaw()
    suspend fun getSlytherin() = dataSource.getSlytherin()
    suspend fun getGryffindor() = dataSource.getGryffindor()
    suspend fun getSpells() = dataSource.getSpells()

}