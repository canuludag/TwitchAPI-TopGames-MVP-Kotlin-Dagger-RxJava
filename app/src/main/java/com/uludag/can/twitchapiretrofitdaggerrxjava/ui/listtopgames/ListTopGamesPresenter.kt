package com.uludag.can.twitchapiretrofitdaggerrxjava.ui.listtopgames

import com.uludag.can.twitchapiretrofitdaggerrxjava.models.Game
import com.uludag.can.twitchapiretrofitdaggerrxjava.models.TwitchTopGames
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListTopGamesPresenter(private val model: ListTopGamesContract.Model) : ListTopGamesContract.Presenter {

    private lateinit var mView: ListTopGamesContract.View
    private lateinit var topGamesList: List<Game>

    override fun getTopGames(){
        mView.showLoading()

        // Make an asynchronous call
        model.fetchTopGames().enqueue(object : Callback<TwitchTopGames>{
            override fun onFailure(call: Call<TwitchTopGames>?, t: Throwable?) {
                mView.showErrorMessage()
            }

            override fun onResponse(call: Call<TwitchTopGames>?, response: Response<TwitchTopGames>?) {
                if (response != null) {
                    val topGames = response.body()
                    if (response.isSuccessful && topGames != null) {
                        topGamesList = topGames.games
                        mView.displayTopGames(topGamesList)
                        mView.hideLoading()
                    }

                }
            }

        })
    }

    override fun setView(view: ListTopGamesContract.View) {
        mView = view
    }

}