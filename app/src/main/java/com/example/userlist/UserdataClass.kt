package com.example.userlist

data class UserdataClass(val username: String, val msg: String)

fun sampleUsers(): List<UserdataClass> {
    return listOf(
        UserdataClass(username = "David Wayne", msg = "Thanks a bunch! Have a gred day!"),
        UserdataClass(username = "Edward Davidson", msg = "Great, thanks so much!"),
        UserdataClass(username = "Angela Kelly", msg = "Appreciate it! See you soon!"),
        UserdataClass(username = "Jean Dare", msg = "Hooray!"),
        UserdataClass(username = "Dennis Borer", msg = "Your order has been successfully delivered"),
        UserdataClass(username = "Cayla Rath", msg = "See you soon!"),
        UserdataClass(username = "Erin Turcotte", msg = "I'm ready to drop off your delivery.",),
        UserdataClass(username = "Rodolfo Walter", msg = "Appreciate it! Hope you enjoy it!",)
    )
}