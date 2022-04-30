package com.quran.network;

import com.quran.response.SurahDetailsResponse;
import com.quran.response.SurahResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SurahServices
{
    @GET("surah")
    Call<SurahResponse> getSurah();

    @GET("sura/{language}/{id}")
    Call<SurahDetailsResponse> getSurahDetails(@Path("language") String lan, @Path("id") int surahID);
}
