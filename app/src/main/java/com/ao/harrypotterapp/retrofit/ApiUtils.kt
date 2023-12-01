package com.ao.harrypotterapp.retrofit

import com.ao.harrypotterapp.utils.Constants

object ApiUtils {
    fun getHarryPotterDao():HarryPotterDao{
        return RetrofitClient.getClient(Constants.BASE_URL).create(HarryPotterDao::class.java)
    }
}