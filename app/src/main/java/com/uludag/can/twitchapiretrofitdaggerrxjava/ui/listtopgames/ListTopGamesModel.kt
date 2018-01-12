package com.uludag.can.twitchapiretrofitdaggerrxjava.ui.listtopgames

import com.uludag.can.twitchapiretrofitdaggerrxjava.BuildConfig
import com.uludag.can.twitchapiretrofitdaggerrxjava.models.TwitchTopGames
import com.uludag.can.twitchapiretrofitdaggerrxjava.networking.TwitchAPIService
import retrofit2.Call
import javax.inject.Inject

class ListTopGamesModel @Inject constructor(private val apiService: TwitchAPIService) : ListTopGamesContract.Model {

    override fun fetchTopGames(): Call<TwitchTopGames> = apiService.getTopGames(BuildConfig.CLIENT_ID)

}