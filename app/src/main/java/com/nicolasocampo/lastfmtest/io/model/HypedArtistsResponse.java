package com.nicolasocampo.lastfmtest.io.model;

import com.google.gson.annotations.SerializedName;
import com.nicolasocampo.lastfmtest.domain.Artist;

import java.util.ArrayList;

/**
 * Created by Nicolas Ocampo on 21/07/2016.
 */
public class HypedArtistsResponse {

    @SerializedName(JsonKeys.ARTISTS_RESULTS)
        HypedArtistsResult result;


        public ArrayList<Artist> getArtists(){
            return result.artists;
        }

        public void setArtists(ArrayList<Artist> artists){
        this.result.artists= artists;
    }

        private class HypedArtistsResult{

            ArrayList<Artist> artists;
        }

}
