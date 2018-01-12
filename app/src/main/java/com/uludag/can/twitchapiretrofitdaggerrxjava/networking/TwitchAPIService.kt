package com.uludag.can.twitchapiretrofitdaggerrxjava.networking

import com.uludag.can.twitchapiretrofitdaggerrxjava.models.TwitchTopGames
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface TwitchAPIService {

    @GET("games/top")
    fun getTopGames(@Header("Client-ID") clientID: String): Call<TwitchTopGames>

}