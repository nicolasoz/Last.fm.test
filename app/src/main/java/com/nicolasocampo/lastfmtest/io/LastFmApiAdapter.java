package com.nicolasocampo.lastfmtest.io;

import retrofit2.Retrofit;

/**
 * Created by Nicolas Ocampo on 21/07/2016.
 */
public class LastFmApiAdapter {

    private static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService(){
        if(API_SERVICE == null){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiConstants.URL_BASE)
                    .build();

            API_SERVICE = retrofit.create(LastFmApiService.class);
        }
        return API_SERVICE;
    }
}
