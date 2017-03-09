package com.arturoguillen.wallapopchallenge.di.api;

import com.arturoguillen.wallapopchallenge.entity.ComicDataWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by artu on 3/8/17.
 */

public interface MarvelApi {

    @GET("characters/{characterId}/comics")
    Observable<ComicDataWrapper> getComicsByCharacter(
            @Path("characterId") int characterId,
            @Query("apikey") String apiKey,
            @Query("ts") String timestamp,
            @Query("hash") String hash);

}
