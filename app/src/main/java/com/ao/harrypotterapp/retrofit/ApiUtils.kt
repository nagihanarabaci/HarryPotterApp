package com.ao.harrypotterapp.retrofit

object ApiUtils {
    val BASE_URL = "https://hp-api.onrender.com/api/"
    fun getHarryPotterDao():HarryPotterDao{
        return RetrofitClient.getClient(BASE_URL).create(HarryPotterDao::class.java)
    }
}