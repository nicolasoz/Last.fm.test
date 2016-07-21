package com.nicolasocampo.lastfmtest.io.model;

import com.google.gson.annotations.SerializedName;
import com.nicolasocampo.lastfmtest.domain.Artist;

import java.util.ArrayList;

/**
 * Created by Nicolas Ocampo on 21/07/2016.
 */
public class HypedArtistsResponse {

    @SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResults results;

    public void setArtist(ArrayList<Artist> artist){
        this.results.artists= artist;
    }


    public ArrayList<Artist> getArtists(){
        return results.artists;
    }


    private class HypedArtistsResults {

        @SerializedName(JsonKeys.ARTIST_ARRAY)
        ArrayList<Artist> artists;
    }


}
