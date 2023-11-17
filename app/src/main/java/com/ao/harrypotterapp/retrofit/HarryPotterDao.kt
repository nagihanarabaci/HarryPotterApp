package com.ao.harrypotterapp.retrofit

import com.ao.harrypotterapp.data.model.Characters
import com.ao.harrypotterapp.data.model.HouseCharacters
import com.ao.harrypotterapp.data.model.Spells
import retrofit2.Call
import retrofit2.http.GET

interface HarryPotterDao {
    @GET("characters")
    suspend fun getCharacters(): List<Characters>

    @GET("characters/house/hufflepuff")
    suspend fun getHufflepuff(): List<HouseCharacters>

    @GET("characters/house/ravenclaw")
    suspend fun getRavenclaw(): List<HouseCharacters>

    @GET("characters/house/slytherin")
    suspend fun getSlytherin(): List<HouseCharacters>

    @GET("characters/house/gryffindor")
    suspend fun getGryffindor(): List<HouseCharacters>

    @GET("spells")
    suspend fun getSpells(): List<Spells>

}