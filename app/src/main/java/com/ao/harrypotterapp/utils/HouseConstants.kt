package com.ao.harrypotterapp.utils

import com.ao.harrypotterapp.R

enum class OnboardingHouses(
    val housesImage: Int,
    val housesDescription: String
) {
    GRYFFINDOR(
        R.drawable.im_gryffindor, "Dear friend, we are welcome you\n" +
                "on official Hogwarts App"
    ),
    SLYTHERIN(
        R.drawable.im_slytherin, "In this app you can buy \n" +
                "all your need goods.\n" +
                "Cauldrons, magic wands, robes..."
    ),
    HUFFLEPUFF(
        R.drawable.im_hufflepuff, "You can follow the schedule \n" +
                "of your lessons, learning spells \n" +
                "and chat with your classmates"
    ),
    RAVENCLAW(
        R.drawable.im_ravenclaw, "For the first log in the App, you need\n" +
                "scan the QR code. You will find that in \n" +
                "the letter brought to you by an owl"
    ),

}

enum class House(val housesName: String) {
    HUFFLEPUFF("Hufflepuff"),
    RAVENCLAW("Ravenclaw"),
    SLYTHERIN("Slytherin"),
    GRYFFINDOR("Gryffindor")
}

enum class HousesCard(val cardResource: Int) {
    GRYFFINDOR_CARD(R.drawable.gryffindor_card),
    HUFFLEPUFF_CARD(R.drawable.hufflepuff_card),
    RAVENCLAW_CARD(R.drawable.ravenclaw_card),
    SLYTHERIN_CARD(R.drawable.slytherin_card)
}


object Constants {
    const val BASE_URL = "https://hp-api.onrender.com/api/"
    const val student = "school"
    const val staff = "staff"
    const val spellsDetail ="Spells Detail"
}