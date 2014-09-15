package com.jfragosoperez.spotiglass;

import android.text.TextUtils;

import java.security.InvalidParameterException;

/**
 *
 */
public final class SpotifySearch {

    public class QueryParams {
        public static final String ALBUM = "album:";
        public static final String ARTIST = "artist:";
        public static final String SONG = "song:";
    }

    public enum SearchType{
        SONG, ALBUM, ARTIST
    }

    private SearchType type;
    private String search;

    public SpotifySearch(SearchType searchType, String searchName){
        if(searchType == null || TextUtils.isEmpty(searchName)){
            throw new InvalidParameterException("");
        }
        this.type = searchType;
        buildSearch(searchName);
    }

    private void buildSearch(String searchName){
        if (isSongSearch()) {
            search = searchName;
        } else if (isAlbumSearch()) {
            search = QueryParams.ALBUM + searchName;
        } else {
            search = QueryParams.ARTIST + searchName;
        }
    }

    public String getSearch(){
        return this.search;
    }

    private SpotifySearch(){}

    private boolean isSongSearch(){
        return this.type.equals(SearchType.SONG);
    }

    private boolean isAlbumSearch(){
        return this.type.equals(SearchType.ALBUM);
    }

    private boolean isArtistSearch(){
        return this.type.equals(SearchType.ARTIST);
    }

}
