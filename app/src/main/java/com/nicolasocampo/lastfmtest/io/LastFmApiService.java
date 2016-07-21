package com.nicolasocampo.lastfmtest.io;

import com.nicolasocampo.lastfmtest.io.model.HypedArtistsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Nicolas Ocampo on 21/07/2016.
 */
public interface LastFmApiService {

    @GET(ApiConstants.URL_HYPED_ARTISTS)
    Call<HypedArtistsResponse> getHypedArtists();
}
