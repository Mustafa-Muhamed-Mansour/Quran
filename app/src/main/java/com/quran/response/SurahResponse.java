package com.quran.response;

import com.google.gson.annotations.SerializedName;
import com.quran.model.SurahModel;

import java.util.ArrayList;


public class SurahResponse
{

    @SerializedName("data")
    private ArrayList<SurahModel> surahModels = null;

    public SurahResponse()
    {
    }

    public ArrayList<SurahModel> getSurahModels() {
        return surahModels;
    }
}
