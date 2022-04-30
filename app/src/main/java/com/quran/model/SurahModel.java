package com.quran.model;

import com.google.gson.annotations.SerializedName;

public class SurahModel
{
    @SerializedName("number")
    private int surahNumber;
    @SerializedName("name")
    private String surahName;
    @SerializedName("englishName")
    private String surahEnglishName;
    @SerializedName("englishNameTranslation")
    private String surahEnglishNameTranslation;
    @SerializedName("numberOfAyahs")
    private int surahNumberOfAyahs;
    @SerializedName("revelationType")
    private String surahRevelationType;

    public SurahModel()
    {
    }

    public int getSurahNumber() {
        return surahNumber;
    }

    public String getSurahName() {
        return surahName;
    }

    public String getSurahEnglishName() {
        return surahEnglishName;
    }

    public String getSurahEnglishNameTranslation() {
        return surahEnglishNameTranslation;
    }

    public int getSurahNumberOfAyahs() {
        return surahNumberOfAyahs;
    }

    public String getSurahRevelationType() {
        return surahRevelationType;
    }
}
