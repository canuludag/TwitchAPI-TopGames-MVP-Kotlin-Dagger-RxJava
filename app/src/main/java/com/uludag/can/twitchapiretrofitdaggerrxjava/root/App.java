package com.uludag.can.twitchapiretrofitdaggerrxjava.root;

import android.app.Application;

import com.uludag.can.twitchapiretrofitdaggerrxjava.networking.ApiModule;
import com.uludag.can.twitchapiretrofitdaggerrxjava.ui.listtopgames.ListTopGamesModule;

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .listTopGamesModule(new ListTopGamesModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
