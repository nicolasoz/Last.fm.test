package com.nicolasocampo.lastfmtest.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolasocampo.lastfmtest.io.deserializer.HypedArtistsDeserializer;
import com.nicolasocampo.lastfmtest.io.model.HypedArtistsResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nicolas Ocampo on 21/07/2016.
 */
public class LastFmApiAdapter {

    private static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService(){
        if(API_SERVICE == null){
            Retrofit adapter = new Retrofit.Builder().baseUrl(ApiConstants.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create(buildLastFmApiGsonConverter())).build();

            API_SERVICE = adapter.create(LastFmApiService.class);
        }
        return API_SERVICE;
    }

    private static Gson buildLastFmApiGsonConverter(){
        Gson gsonConf = new GsonBuilder()
                .registerTypeAdapter(HypedArtistsResponse.class, new HypedArtistsDeserializer())
                .create();


        return gsonConf;
    }
}
