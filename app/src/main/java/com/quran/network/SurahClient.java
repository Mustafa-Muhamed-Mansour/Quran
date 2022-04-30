package com.quran.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SurahClient
{
    private static Retrofit retrofit;
    private static String BASE_URL_SURAH = "http://api.alquran.cloud/v1/";
    private static String BASE_URL = "https://quranenc.com/api/translation/";

    public Retrofit getRetrofit()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit
                    .Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL_SURAH)
                    .build();
        }

        return retrofit;
    }

    public Retrofit getInstance()
    {
        if (retrofit != null)
        {
            retrofit = null;
        }

        retrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        return retrofit;
    }
}
