package com.uludag.can.twitchapiretrofitdaggerrxjava.root;

import com.uludag.can.twitchapiretrofitdaggerrxjava.networking.ApiModule;
import com.uludag.can.twitchapiretrofitdaggerrxjava.ui.listtopgames.ListTopGamesActivity;
import com.uludag.can.twitchapiretrofitdaggerrxjava.ui.listtopgames.ListTopGamesModel;
import com.uludag.can.twitchapiretrofitdaggerrxjava.ui.listtopgames.ListTopGamesModule;

import dagger.Component;

@Component(modules = {AppModule.class, ApiModule.class, ListTopGamesModule.class})
public interface AppComponent {
    void inject(ListTopGamesActivity target);
    void inject(ListTopGamesModel target);
}
