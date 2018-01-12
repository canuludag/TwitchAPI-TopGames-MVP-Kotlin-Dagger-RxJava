package com.uludag.can.twitchapiretrofitdaggerrxjava.ui.listtopgames

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.uludag.can.twitchapiretrofitdaggerrxjava.R
import com.uludag.can.twitchapiretrofitdaggerrxjava.models.Game
import com.uludag.can.twitchapiretrofitdaggerrxjava.root.App
import kotlinx.android.synthetic.main.activity_list_top_games.*
import javax.inject.Inject

class ListTopGamesActivity : AppCompatActivity(), ListTopGamesContract.View {

    @Inject lateinit var mPresenter: ListTopGamesContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_top_games)
        // Dagger injection
        (application as App).appComponent.inject(this)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun displayTopGames(topGamesList: List<Game>) {
        recyclerView.adapter = TopGamesAdapter(topGamesList)
    }

    override fun showErrorMessage() {
        Toast.makeText(this, "An error occured!", Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        mPresenter.setView(this)
        mPresenter.getTopGames()
    }
}
