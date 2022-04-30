package com.quran.model;

import com.google.gson.annotations.SerializedName;

public class SurahDetailModel
{
    @SerializedName("id")
    private String id;
    @SerializedName("sura")
    private String sura;
    @SerializedName("aya")
    private String aya;
    @SerializedName("arabic_text")
    private String ayahArabicText;
    @SerializedName("translation")
    private String ayahTranslation;
    @SerializedName("footnotes")
    private String ayahFootnotes;

    public SurahDetailModel()
    {
    }

//    public SurahDetailModel(String id, String sura, String aya, String arabicText, String translation, String footnotes)
//    {
//        this.id = id;
//        this.sura = sura;
//        this.aya = aya;
//        this.arabicText = arabicText;
//        this.translation = translation;
//        this.footnotes = footnotes;
//    }

    public String getId() {
        return id;
    }

    public String getSura() {
        return sura;
    }

    public String getAya() {
        return aya;
    }

    public String getAyahArabicText() {
        return ayahArabicText;
    }

    public String getAyahTranslation() {
        return ayahTranslation;
    }

    public String getAyahFootnotes() {
        return ayahFootnotes;
    }
}
