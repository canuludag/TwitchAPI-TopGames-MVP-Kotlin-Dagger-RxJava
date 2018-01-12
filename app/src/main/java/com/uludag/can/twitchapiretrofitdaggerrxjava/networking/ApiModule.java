package com.uludag.can.twitchapiretrofitdaggerrxjava.networking;

import com.uludag.can.twitchapiretrofitdaggerrxjava.BuildConfig;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    OkHttpClient provideClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    }

    @Provides
    Retrofit provideRetrofit(String baseUrl, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    TwitchAPIService provideApiService() {
        return provideRetrofit(BuildConfig.BASE_URL, provideClient()).create(TwitchAPIService.class);
    }

}
