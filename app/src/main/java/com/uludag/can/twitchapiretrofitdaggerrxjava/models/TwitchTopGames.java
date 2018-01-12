
package com.uludag.can.twitchapiretrofitdaggerrxjava.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TwitchTopGames {

    @SerializedName("data")
    @Expose
    private List<Game> games = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
