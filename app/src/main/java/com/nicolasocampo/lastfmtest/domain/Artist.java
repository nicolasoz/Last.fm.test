package com.nicolasocampo.lastfmtest.domain;

import com.google.gson.annotations.SerializedName;
import com.nicolasocampo.lastfmtest.io.model.JsonKeys;

/**
 * Created by Nicolás on 20/07/2016.
 */
public class Artist {

    @SerializedName(JsonKeys.ARTIST_NAME)
    private String name;

    private String urlMediumImage;
    private String urlLargeImage;

    public Artist() {
    }

    public Artist(String name) { this.name = name; }

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }


    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }

    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }
}
