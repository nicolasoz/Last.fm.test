package com.nicolasocampo.lastfmtest.io.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.nicolasocampo.lastfmtest.domain.Artist;
import com.nicolasocampo.lastfmtest.io.model.HypedArtistsResponse;
import com.nicolasocampo.lastfmtest.io.model.JsonKeys;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Nicolás on 25/07/2016.
 */
public class HypedArtistsDeserializer implements JsonDeserializer<HypedArtistsResponse> {
    @Override
    public HypedArtistsResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        HypedArtistsResponse response = gson.fromJson(json, HypedArtistsResponse.class);

        //Obtener el objeto artists
        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTISTS_RESULTS);

        //Obtener el Array de artists
        JsonArray artistsArray = artistResponseData.getAsJsonArray(JsonKeys.ARTIST_ARRAY);

        //convertir el jsonArray de artists a objetos de la clase Artist
        response.setArtists(extractArtistsFromJsonArray(artistsArray));
        return response;
    }

    private ArrayList<Artist> extractArtistsFromJsonArray(JsonArray array){
        ArrayList<Artist> artists = new ArrayList<>();

        for (int i = 0; i < array.size() ; i++) {
            JsonObject artistData = array.get(i).getAsJsonObject();

            Artist currentArtist = new Artist();

            //obtener el nombre
            String name = artistData.get(JsonKeys.ARTIST_NAME).getAsString();

            //obtener las imagenes
            JsonArray imagesArray = artistData.getAsJsonArray(JsonKeys.ARTIST_IMAGES);
            String[] images = extractArtistImagesFromJsonArray(imagesArray);

            //Artista con todos la informacion seteada
            currentArtist.setName(name);
            currentArtist.setUrlMediumImage(images[0]);
            currentArtist.setUrlLargeImage(images[1]);

            artists.add(currentArtist);
        }

        return artists;
    }

    private String [] extractArtistImagesFromJsonArray(JsonArray imagesArray){
        String[] images = new String[2];

        for (int i = 0; i <imagesArray.size(); i++) {
            JsonObject imageData = imagesArray.get(i).getAsJsonObject();

            String size= imageData.get(JsonKeys.IMAGE_SIZE).getAsString();
            String url= imageData.get(JsonKeys.IMAGE_URL).getAsString();

            if(url.isEmpty())
                url=null;

            if (size.matches(JsonKeys.IMAGE_MEDIUM)){
                images[0] = url;}

            else if (size.matches(JsonKeys.IMAGE_LARGE)){
                images[1] = url;}
        }

        return images;
    }
}
