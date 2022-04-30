package com.quran.response;

import com.google.gson.annotations.SerializedName;
import com.quran.model.SurahDetailModel;

import java.util.ArrayList;

public class SurahDetailsResponse
{
    @SerializedName("result")
    private ArrayList<SurahDetailModel> surahDetailModels = null;

    public SurahDetailsResponse()
    {
    }

    public ArrayList<SurahDetailModel> getSurahDetailModels() {
        return surahDetailModels;
    }
}
