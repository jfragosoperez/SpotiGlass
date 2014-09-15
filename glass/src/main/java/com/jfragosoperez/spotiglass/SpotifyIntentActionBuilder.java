package com.jfragosoperez.spotiglass;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.provider.MediaStore;

/**
 *
 */
public final class SpotifyIntentActionBuilder {

    public static final String SPOTIFY_APP_PACKAGE = "com.spotify.music";

    public static final String SPOTIFY_APP_PACKAGE_MAIN_ACTIVITY = "com.spotify.music.MainActivity";

//    android.intent.action.VIEW spotify:user:username:starred

//    com.spotify.music/com.spotify.music.MainActivity" -a android.media.action.MEDIA_PLAY_FROM_SEARCH -e query "artist:artistname"

    public static Intent buildPlayIntent(SpotifySearch search) {
        try {
            Intent intent = buildBaseIntent();
            intent.setAction(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
            intent.putExtra(SearchManager.QUERY, search.getSearch());

            return intent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Intent buildViewIntent(SpotifySearch search){
        Intent intent = buildBaseIntent();
        intent.setAction(Intent.ACTION_VIEW);

        return intent;
    }

    private static Intent buildBaseIntent(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setComponent(new ComponentName(SPOTIFY_APP_PACKAGE,
                SPOTIFY_APP_PACKAGE_MAIN_ACTIVITY));

        return intent;
    }

}
