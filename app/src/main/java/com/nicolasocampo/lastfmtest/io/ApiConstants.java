package com.nicolasocampo.lastfmtest.io;

/**
 * Created by Nicolas Ocampo on 21/07/2016.
 */
public class ApiConstants {

    public static final String API_KEY ="dad203a19b7cb5283c1a8be45cd6c11f";

    public static final String URL_BASE ="http://ws.audioscrobbler.com";

    public static final String PATH_VERSION="/2.0";

    public static final String PARAM_METHOD="method";
    public static final String PARAM_FORMAT="format";
    public static final String PARAM_API_KEY="api_key";

    public static final String VALUE_HYPED_ARTIST_METHOD ="chart.gettopartists";
    public static final String VALUE_JSON ="json";

    //?method=chart.gettopartists&api_key=dad203a19b7cb5283c1a8be45cd6c11f&format=json
    public static final String URL_HYPED_ARTISTS ="?" +PARAM_METHOD +"="+ VALUE_HYPED_ARTIST_METHOD + "&" + PARAM_API_KEY
            + "=" + API_KEY + "&" + PARAM_FORMAT + "=" + VALUE_JSON;
}
