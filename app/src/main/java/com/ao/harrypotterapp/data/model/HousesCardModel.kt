package com.ao.harrypotterapp.data.model

import com.ao.harrypotterapp.utils.House
import java.io.Serializable

data class HousesCardModel(var imageName:String, var backgroundResource:Int, var house: House) : Serializable
