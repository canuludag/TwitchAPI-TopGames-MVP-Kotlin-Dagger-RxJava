package com.uludag.can.twitchapiretrofitdaggerrxjava.ui.listtopgames

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.uludag.can.twitchapiretrofitdaggerrxjava.R
import com.uludag.can.twitchapiretrofitdaggerrxjava.models.Game
import kotlinx.android.synthetic.main.list_item.view.*

class TopGamesAdapter(private val games: List<Game>): RecyclerView.Adapter<TopGamesAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent,false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder?, position: Int) {
        if (holder != null) {
            val game = games[position]
            holder.view.tvGameName.text = game.name
            Glide.with(holder.view)
                    .load(game.boxArtUrl.replace("{width}","320")
                            .replace("{height}","320"))
                    .into(holder.view.ivGameCover)
        }
    }

    override fun getItemCount() = games.size

    class GameViewHolder(val view: View): RecyclerView.ViewHolder(view)

}