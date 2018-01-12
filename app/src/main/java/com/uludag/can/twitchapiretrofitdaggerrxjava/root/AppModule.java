package com.uludag.can.twitchapiretrofitdaggerrxjava.root;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    private App mApp;

    AppModule(App app) {
        mApp = app;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return mApp.getApplicationContext();
    }
}
