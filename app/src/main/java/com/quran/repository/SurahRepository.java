package com.quran.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.quran.network.SurahClient;
import com.quran.network.SurahServices;
import com.quran.response.SurahResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahRepository
{

    private SurahServices surahServices;
    private MutableLiveData<SurahResponse> surahResponseMutableLiveData;
    private MutableLiveData<String> stringMutableLiveData;

    public SurahRepository()
    {
        surahServices = new SurahClient()
                .getRetrofit()
                .create(SurahServices.class);

        surahResponseMutableLiveData = new MutableLiveData<>();
        stringMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<SurahResponse> getSurah()
    {
        surahServices
                .getSurah()
                .enqueue(new Callback<SurahResponse>()
                {
                    @Override
                    public void onResponse(Call<SurahResponse> call, Response<SurahResponse> response)
                    {
                        surahResponseMutableLiveData.setValue(response.body());
                        stringMutableLiveData.setValue("Sucess");
                    }

                    @Override
                    public void onFailure(Call<SurahResponse> call, Throwable t)
                    {
                        surahResponseMutableLiveData.postValue(null);
                        stringMutableLiveData.setValue(t.toString());
                    }
                });

        return surahResponseMutableLiveData;
    }
}
