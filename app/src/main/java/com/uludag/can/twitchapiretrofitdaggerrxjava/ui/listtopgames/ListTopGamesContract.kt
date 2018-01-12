package com.uludag.can.twitchapiretrofitdaggerrxjava.ui.listtopgames

import com.uludag.can.twitchapiretrofitdaggerrxjava.models.Game
import com.uludag.can.twitchapiretrofitdaggerrxjava.models.TwitchTopGames
import retrofit2.Call

interface ListTopGamesContract {
    interface View {
        fun displayTopGames(topGamesList: List<Game>)
        fun showErrorMessage()
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun setView(view: ListTopGamesContract.View)
        fun getTopGames()
    }

    interface Model {
        fun fetchTopGames(): Call<TwitchTopGames>
    }
}