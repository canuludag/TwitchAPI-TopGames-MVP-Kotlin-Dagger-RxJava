package com.uludag.can.twitchapiretrofitdaggerrxjava.ui.listtopgames;

import com.uludag.can.twitchapiretrofitdaggerrxjava.networking.ApiModule;
import com.uludag.can.twitchapiretrofitdaggerrxjava.networking.TwitchAPIService;

import dagger.Module;
import dagger.Provides;

@Module(includes = ApiModule.class)
public class ListTopGamesModule {

    @Provides
    ListTopGamesContract.Presenter providePresenter(ListTopGamesContract.Model model) {
        return new ListTopGamesPresenter(model);
    }

    @Provides
    ListTopGamesContract.Model provideModel(TwitchAPIService apiService) {
        return new ListTopGamesModel(apiService);
    }

}
