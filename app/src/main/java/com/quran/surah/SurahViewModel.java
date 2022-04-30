package com.quran.surah;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.quran.repository.SurahRepository;
import com.quran.response.SurahResponse;

public class SurahViewModel extends ViewModel
{

    private SurahRepository surahRepository;


    public SurahViewModel()
    {
        surahRepository = new SurahRepository();
    }

    public LiveData<SurahResponse> getSurah()
    {
        return surahRepository.getSurah();
    }
}