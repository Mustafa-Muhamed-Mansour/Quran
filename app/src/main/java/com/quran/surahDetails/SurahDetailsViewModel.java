package com.quran.surahDetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.quran.repository.SurahDetailsRepository;
import com.quran.response.SurahDetailsResponse;

public class SurahDetailsViewModel extends ViewModel
{

    private SurahDetailsRepository surahDetailsRepository;

    public SurahDetailsViewModel()
    {
        surahDetailsRepository = new SurahDetailsRepository();
    }

    public LiveData<SurahDetailsResponse> getSurahDetails(String lan, int id)
    {
        return surahDetailsRepository.getSurahDetails(lan, id);
    }
}